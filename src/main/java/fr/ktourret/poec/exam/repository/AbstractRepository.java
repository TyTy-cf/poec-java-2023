package fr.ktourret.poec.exam.repository;

import fr.ktourret.poec.exam.entity.EntityInterface;
import fr.ktourret.poec.exam.service.DBConnect;

import javax.management.Query;
import java.sql.*;
import java.util.*;

public abstract class AbstractRepository<T extends EntityInterface> {

    protected String tableName;

    protected long queriesFromMap;

    protected long queriesFromDB ;

    protected final Map<String, List<T>> tmpEntities = new HashMap<>();

    protected final Connection connection = DBConnect.getConnection();

    protected AbstractRepository(String tableName) {
        this.tableName = tableName;
    }

    abstract protected T getObject(ResultSet rs);

    private String getSelect() {
        return "SELECT * FROM " + tableName;
    }

    public final List<T> findAll() {
        return findBy(null, null, null);
    }

    public final T findOneBy(String field, Object value) {
        // Instancier une map avec des String en clé et Object en valeur
        Map<String, Object> fields = new HashMap<>();
        // J'ajoute les paramètres de la fonction dans la map
        fields.put(field, value);
        // Récupérer le retour de la fonction findBy, auquel on passe la map en 1er paramètre
        List<T> objects = findBy(fields, null, null);
        // Si ma liste est vide, je renvoie null
        if (objects.isEmpty()) {
            return null;
        }
        // je renvoie le premier élément de la liste
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

        System.out.println("Query called : " + query);
        if (tmpEntities.containsKey(query)) {
            queriesFromMap++;
            return tmpEntities.get(query);
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                objects.add(getObject(rs));
            }
            queriesFromDB++;
            tmpEntities.put(query, objects);
        } catch (SQLException e) {
            catchException(e, query);
        }
        return objects;
    }

    protected int findPopulationByQuery(String query, Long id) {
        int population = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                population = rs.getInt("population");
            }
        } catch (SQLException e) {
            catchException(e, query);
        }
        return population;
    }

    protected void catchException(Exception e, String query) {
        System.out.println("Someting goes wrong with this query :\n");
        System.out.println(query);
        System.out.println("\n");
        System.out.println("Message : " + e.getMessage());
    }

}
