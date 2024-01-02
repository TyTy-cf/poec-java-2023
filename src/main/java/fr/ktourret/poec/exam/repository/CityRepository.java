package fr.ktourret.poec.exam.repository;

import fr.ktourret.poec.exam.entity.geogouv.City;
import fr.ktourret.poec.exam.entity.geogouv.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRepository extends AbstractRepository<City> {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    public CityRepository() {
        super("city");
    }

    @Override
    protected City getObject(ResultSet rs) {
        City city = new City();
        try {
            city.setId(rs.getLong("id"));
            city.setName(rs.getString("name"));
            city.setCode(rs.getString("code"));
            city.setPopulation(rs.getInt("population"));
            city.setSiren(rs.getString("siren"));
            city.setDepartment(departmentRepository.findOneBy("id", rs.getString("department_id")));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a City object : " + e.getMessage());
            city = null;
        }
        return city;
    }
}
