package fr.ktourret.poec.my_mvc.repository.instant_faking;

import fr.ktourret.poec.my_mvc.entity.instant_faking.Country;
import fr.ktourret.poec.my_mvc.repository.AbstractRepository;

import java.sql.*;

public class CountryRepository extends AbstractRepository<Country> {

    private static CountryRepository instance;

    private CountryRepository() {
        super("country");
    }

    public static CountryRepository getRepository() {
        if (instance == null) {
            instance = new CountryRepository();
        }
        return instance;
    }

    @Override
    protected Country update(Country object) {
        try {
            object.setUrlFlag("https://flagcdn.com/32x24/" + object.getCode() + ".png");
            object.setSlug(object.getName().toLowerCase());

            String query = "UPDATE country SET code = ?, name = ?, nationality = ?, slug = ?, url_flag = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, object.getCode());
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getNationality());
            stmt.setString(4, object.getSlug());
            stmt.setString(5, object.getUrlFlag());
            stmt.setLong(6, object.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong during update of a Country : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Country insert(Country object) {
        try {
            object.setUrlFlag("https://flagcdn.com/32x24/" + object.getCode() + ".png");
            object.setSlug(object.getName().toLowerCase());

            String query = "INSERT INTO country VALUES (null, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, object.getCode());
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getNationality());
            stmt.setString(4, object.getSlug());
            stmt.setString(5, object.getUrlFlag());
            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a Country : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Country getObject(ResultSet rs) {
        Country country = new Country();
        try {
            country.setId(rs.getLong("id"));
            country.setCode(rs.getString("code"));
            country.setName(rs.getString("name"));
            country.setNationality(rs.getString("nationality"));
            country.setSlug(rs.getString("slug"));
            country.setUrlFlag(rs.getString("url_flag"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Country object : " + e.getMessage());
            country = null;
        }
        return country;
    }
}
