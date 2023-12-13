package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Category;

import java.sql.ResultSet;
import java.util.List;

public class CategoryRepository extends AbstractRepository<Category> {

    @Override
    protected Category getObjectFromResultSet(ResultSet rs) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findOneBy(String field, Object value) {
        return null;
    }

    @Override
    public boolean delete(Category object) {
        return false;
    }

    @Override
    protected Category update(Category object) throws IncompleteDAOException {
        return null;
    }

    @Override
    protected Category insert(Category object) throws IncompleteDAOException {
        return null;
    }
}
