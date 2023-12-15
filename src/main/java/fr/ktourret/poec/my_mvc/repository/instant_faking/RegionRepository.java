package fr.ktourret.poec.my_mvc.repository.instant_faking;

import fr.ktourret.poec.my_mvc.entity.Region;
import fr.ktourret.poec.my_mvc.repository.AbstractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegionRepository extends AbstractRepository<Region> {

    public RegionRepository() {
        super("region");
    }

    @Override
    protected Region update(Region object) {
        try {
            String query = "UPDATE region SET name = ?, code = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getCode());
            stmt.setLong(3, object.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong during update of a Region : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Region insert(Region object) {
        try {
            String query = "INSERT INTO region VALUES (null, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getCode());
            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a Region : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Region getObject(ResultSet rs) {
        Region region = new Region();
        try {
            region.setId(rs.getLong("id"));
            region.setName(rs.getString("name"));
            region.setCode(rs.getString("code"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Category object : " + e.getMessage());
            region = null;
        }
        return region;
    }
}
