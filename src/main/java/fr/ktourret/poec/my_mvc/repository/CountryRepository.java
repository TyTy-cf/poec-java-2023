package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.service.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository extends AbstractRepository<Country> {

    private final Connection connection = DBConnect.getConnection();

    @Override
    public List<Country> findAll() {
        List<Country> countries = new ArrayList<>();
        try {
            // stmt : c'est à partir de lui que l'on exécute une requête
            // On le récupère depuis l'object "Connection"
            Statement stmt = connection.createStatement();
            // Une requête est récupérée sous forme d'un ResultSet
            // Un ResultSet n'est autre qu'un ensemble clé + valeur
            // Dans lequel la clé est le nom de la colonne en BDD
            ResultSet rs = stmt.executeQuery("SELECT * FROM country");
            // rs.next = une ligne de la BDD
            while (rs.next()) {
                Country country = getObjectFromResultSet(rs);
                if (country != null) {
                    countries.add(country);
                }
            }
        } catch (SQLException e) {
            System.out.println("Something goes wrong in findAll : " + e.getMessage());
        }
        return countries;
    }

    @Override
    public Country findOneBy(String field, Object value) {
        return null;
    }

    @Override
    public boolean delete(Country object) {
        return false;
    }

    @Override
    protected Country update(Country object) throws IncompleteDAOException {
        throw new IncompleteDAOException("update n'a pas été implémenté...");
//        return null;
    }

    @Override
    protected Country insert(Country object) throws IncompleteDAOException {
        throw new IncompleteDAOException("insert n'a pas été implémenté...");
    }

    @Override
    protected Country getObjectFromResultSet(ResultSet rs) {
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
