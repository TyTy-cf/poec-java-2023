package fr.ktourret.poec.my_mvc.repository.pokemon;

import fr.ktourret.poec.my_mvc.entity.instant_faking.Country;
import fr.ktourret.poec.my_mvc.entity.pokemon.Pokemon;
import fr.ktourret.poec.my_mvc.repository.AbstractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PokemonRepository extends AbstractRepository<Pokemon> {

    public PokemonRepository() {
        super("pokemon");
    }

    @Override
    protected Pokemon update(Pokemon object) {
        return null;
    }

    @Override
    protected Pokemon insert(Pokemon object) {
        try {
            String query = "INSERT INTO pokemon VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, object.getPokedexId());
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getFrontDefault());
            stmt.setString(4, object.getFrontShiny());
            stmt.setInt(5, object.getHeight());
            stmt.setInt(6, object.getWeight());
            stmt.setInt(7, object.getBaseExperience());
            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a Pokemon : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Pokemon getObject(ResultSet rs) {
        Pokemon pokemon = new Pokemon();
        try {
            pokemon.setId(rs.getLong("id"));
            pokemon.setPokedexId(rs.getLong("pokedex_id"));
            pokemon.setName(rs.getString("name"));
            pokemon.setWeight(rs.getInt("weight"));
            pokemon.setHeight(rs.getInt("height"));
            pokemon.setBaseExperience(rs.getInt("base_experience"));
            pokemon.setFrontShiny(rs.getString("front_shiny"));
            pokemon.setFrontDefault(rs.getString("front_default"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Pokemon object : " + e.getMessage());
            pokemon = null;
        }
        return pokemon;
    }

}
