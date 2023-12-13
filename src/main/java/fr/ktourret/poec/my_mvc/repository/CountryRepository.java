package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.service.DBConnect;

import java.nio.channels.SelectableChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryRepository extends AbstractRepository<Country> {

    private final Connection connection = DBConnect.getConnection();

    public CountryRepository() {
        super(Country.class);
    }

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
        Country country = null;
        try {
            PreparedStatement prepare = connection.prepareStatement(
                    "SELECT * FROM country WHERE " + field + " = ?"
            );
            prepare.setObject(1, value);
            ResultSet rs = prepare.executeQuery();
            if (rs.first()) { // Vérifie si le premier élément existe
                country = getObjectFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println("Something goes wrong while calling fineOneBy from CountryRepository " + e.getMessage());
        }
        return country;
    }

    @Override
    public List<Country> findBy(Map<String, Object> fields, Integer limit, Map<String, String> orders) {
        StringBuilder select = new StringBuilder("SELECT * FROM country");
        if (fields != null && !fields.isEmpty()) {
            select.append(" WHERE ");
            for (Map.Entry<String, Object> field : fields.entrySet()) {
                select.append(field.getKey());
                select.append(" = ");
                select.append(field.getValue());
                select.append(" AND ");
            }
            select.delete(select.length() - 4, select.length());
        }
        if (limit != null) {
            select.append(" LIMIT ");
            select.append(limit);
        }
        if (orders != null && !orders.isEmpty()) {
            select.append(" ORDER BY ");
            for (Map.Entry<String, String> order : orders.entrySet()) {
                select.append(order.getKey());
                select.append(" ");
                select.append(order.getValue());
                select.append(", ");
            }
            select.delete(select.length() - 2, select.length());
        }

        List<Country> countries = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Something goes wrong inside findBy for Country : " + e.getMessage());
        }
        return countries;
    }

    @Override
    public boolean delete(Country object) {
        boolean isOK = true;
        try {
            PreparedStatement prepare = connection.prepareStatement("");
        } catch (SQLException e) {
            System.out.println("Something went wrong during delete of a Country : " + e.getMessage());
            isOK = false;
        }
        return isOK;
    }

    @Override
    protected Country update(Country object) {
        try {
            object.setUrlFlag("https://flagcdn.com/32x24/" + object.getCode() + ".png");

            String query = "UPDATE country SET code = ?, name = ?, nationality = ?, slug = ?, url_flag = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("Something went wrong during update of a Country : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Country insert(Country object) {
        try {
            object.setUrlFlag("https://flagcdn.com/32x24/" + object.getCode() + ".png");

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
