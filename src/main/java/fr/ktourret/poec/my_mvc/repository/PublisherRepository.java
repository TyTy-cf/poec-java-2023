package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.entity.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class PublisherRepository extends AbstractRepository<Publisher> {

    private CountryRepository countryRepository = CountryRepository.getInstance();

    public PublisherRepository() {
        super("publisher");
    }

    @Override
    protected Publisher update(Publisher object) {
        try {
            String query = "UPDATE publisher SET name = ?, website = ?, slug = ?, country_id = ?, created_at = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getWebsite());
            stmt.setString(3, object.getSlug());
            Long id = null;
            if (object.getCountry() != null) {
                id = object.getCountry().getId();
            }
            stmt.setObject(4, id);
            stmt.setString(5, getDateFormat(object.getCreatedAt()));
            stmt.setLong(6, object.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong during update of a Publisher : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Publisher insert(Publisher object) {
        try {
            String query = "INSERT INTO publisher VALUES (null, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, getDateFormat(object.getCreatedAt()));
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getSlug());
            stmt.setString(4, object.getWebsite());
            Long id = null;
            if (object.getCountry() != null) {
                id = object.getCountry().getId();
            }
            stmt.setObject(5, id);
            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a Publisher : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Publisher getObject(ResultSet rs) {
        Publisher publisher = new Publisher();
        try {
            publisher.setId(rs.getLong("id"));
            publisher.setName(rs.getString("name"));
            publisher.setWebsite(rs.getString("website"));
            publisher.setCreatedAt(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("created_at")));            publisher.setSlug(rs.getString("slug"));
            publisher.setCountry(countryRepository.findOneBy("id", rs.getLong("country_id")));
        } catch (SQLException | ParseException e) {
            System.out.println("Something goes wrong while creating a Publisher object : " + e.getMessage());
            publisher = null;
        }
        return publisher;
    }

}
