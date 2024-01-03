package fr.ktourret.poec.exam.repository;

import fr.ktourret.poec.exam.entity.geogouv.City;
import fr.ktourret.poec.exam.entity.geogouv.Department;
import fr.ktourret.poec.exam.entity.geogouv.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityRepository extends AbstractRepository<City> {

    private DepartmentRepository departmentRepository = new DepartmentRepository();

    public CityRepository() {
        super("city");
    }

    public List<City> findByDepartment(Department department) {
        Map<String, Object> fields = new HashMap<>();
        fields.put("department_id", department.getId());
        return findBy(fields, null, null);
    }

    public List<City> findByRegion(Region region) {
        String query =
                "SELECT city.* " +
                "FROM city " +
                "JOIN department ON city.department_id = department.id " +
                "JOIN region ON department.region_id = region.id " +
                "WHERE region.id = ?;";
        List<City> objects = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, region.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                objects.add(getObject(rs));
            }
        } catch (SQLException e) {
            catchException(e, query);
            objects = List.of();
        }
        return objects;
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
