package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.EntityInterface;

import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractRepository<T extends EntityInterface> {

    protected T object;

    protected String tableName;

    AbstractRepository(Class<T> className) {
        // className.getSimpleName().toLowerCase() = nom de la table de l'objet
        tableName = className.getSimpleName().toLowerCase();
    }

    abstract public List<T> findAll();

    abstract public T findOneBy(String field, Object value);

    abstract public boolean delete(T object);

    abstract protected T update(T object) throws IncompleteDAOException;

    abstract protected T insert(T object) throws IncompleteDAOException;

    abstract protected T getObjectFromResultSet(ResultSet rs);

    public final T save(T object) throws IncompleteDAOException {
        if (object.getId() != null) {
            return update(object);
        }
        return insert(object);
    }

}
