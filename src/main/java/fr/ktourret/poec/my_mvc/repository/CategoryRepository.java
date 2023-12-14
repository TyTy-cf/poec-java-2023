package fr.ktourret.poec.my_mvc.repository;

import fr.ktourret.poec.my_mvc.entity.Category;

import java.sql.ResultSet;

public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository() {
        super("category");
    }

    @Override
    protected Category update(Category object) {
        return null;
    }

    @Override
    protected Category insert(Category object) {
        return null;
    }

    @Override
    protected Category getObject(ResultSet rs) {
        return null;
    }
}
