package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.EntityInterface;
import fr.ktourret.poec.my_mvc.service.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<T extends EntityInterface> {

    protected String tableName;

    protected final Connection connection = DBConnect.getConnection();

    protected AbstractRepository(String tableName) {
        this.tableName = tableName;
    }

    abstract protected T update(T object);

    abstract protected T insert(T object);

    abstract protected T getObject(ResultSet rs);

    private String getSelect() {
        return "SELECT * FROM " + tableName;
    }

    public final List<T> findAll() {
        return findBy(null, null, null);
    }

    public final T findOneBy(String field, Object value) {
        Map<String, Object> fields = new HashMap<>();
        fields.put(field, value);
        List<T> objects = findBy(fields, null, null);
        if (objects.isEmpty()) {
            return null;
        }
        return objects.get(0);
    }

    public final List<T> findBy(Map<String, Object> fields, Integer limit, Map<String, String> orders) {
        StringBuilder select = new StringBuilder(getSelect());
        if (fields != null && !fields.isEmpty()) {
            select.append(" WHERE ");
            for (Map.Entry<String, Object> field : fields.entrySet()) {
                select.append(field.getKey()); // colonne de la table
                select.append(" = '");
                select.append(field.getValue()); // valeur recherchée
                select.append("' AND ");
            }
            select.delete(select.length() - 5, select.length());
        }
        if (limit != null) {
            select.append(" LIMIT ");
            select.append(limit);
        }
        if (orders != null && !orders.isEmpty()) {
            select.append(" ORDER BY ");
            for (Map.Entry<String, String> order : orders.entrySet()) {
                select.append(order.getKey()); // colonne de la table
                select.append(" ");
                select.append(order.getValue()); // DESC ou ASC
                select.append(", ");
            }
            select.delete(select.length() - 2, select.length());
        }
        List<T> objects = new ArrayList<>();
        String query = select.toString();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                objects.add(getObject(rs));
            }
        } catch (SQLException e) {
            catchException(e, query);
        }
        return objects;
    }

    public final boolean delete(T object) {
        boolean isOK = true;
        PreparedStatement prepare = null;
        try {
            prepare = connection.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
            prepare.setLong(1, object.getId());
            prepare.executeUpdate();
        } catch (SQLException e) {
            assert prepare != null;
            catchException(e, prepare.toString());
            isOK = false;
        }
        return isOK;
    }

    public final T save(T object) {
        if (object.getId() != null) {
            return update(object);
        }
        return insert(object);
    }

    private void catchException(Exception e, String query) {
        System.out.println("Someting goes wrong with this query :\n");
        System.out.println(query);
        System.out.println("\n");
        System.out.println("Message : " + e.getMessage());
    }

}
