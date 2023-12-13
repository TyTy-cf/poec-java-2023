package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Category;
import fr.ktourret.poec.my_mvc.entity.Country;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository() {
        super(Category.class);
    }

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
    public List<Category> findBy(Map<String, Object> fields, Integer limit, Map<String, String> order) {
        return null;
    }

    @Override
    public boolean delete(Category object) {
        return false;
    }

    @Override
    protected Category update(Category object) {
        return null;
    }

    @Override
    protected Category insert(Category object) {
        return null;
    }
}
