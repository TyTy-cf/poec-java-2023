package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository() {
        super("category");
    }

    @Override
    protected Category update(Category object) {
        try {
            String query = "UPDATE category SET name = ?, image = ?, slug = ? WHERE id = ?;";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, object.getName());
            stmt.setString(2, object.getImage());
            stmt.setString(3, object.getSlug());
            stmt.setLong(4, object.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Something went wrong during update of a Category : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Category insert(Category object) {
        try {
            String query = "INSERT INTO category VALUES (null, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, object.getImage());
            stmt.setString(2, object.getName());
            stmt.setString(3, object.getSlug());
            stmt.executeUpdate();
            // getGeneratedKeys = retourne l'id du dernier objet inséré
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                // on le set à notre objet de retour
                object.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong during insert of a Category : " + e.getMessage());
        }
        return object;
    }

    @Override
    protected Category getObject(ResultSet rs) {
        Category category = new Category();
        try {
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            category.setImage(rs.getString("image"));
            category.setSlug(rs.getString("slug"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Category object : " + e.getMessage());
            category = null;
        }
        return category;
    }
}
