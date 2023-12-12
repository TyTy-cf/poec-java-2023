package fr.ktourret.poec.my_mvc.repository;

import java.sql.ResultSet;

public abstract class AbstractRepository<T> {

    abstract protected T getObjectFromResultSet(ResultSet rs);

}
