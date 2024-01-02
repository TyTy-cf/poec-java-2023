package fr.ktourret.poec.exam.repository;

import fr.ktourret.poec.exam.entity.geogouv.Department;
import fr.ktourret.poec.exam.entity.geogouv.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentRepository extends AbstractRepository<Department> {

    private RegionRepository regionRepository = new RegionRepository();

    public DepartmentRepository() {
        super("department");
    }

    public List<Department> findByRegion(Region region) {
        Map<String, Object> fields = new HashMap<>();
        fields.put("region_id", region.getId());
        return findBy(fields, null, null);
    }

    @Override
    protected Department getObject(ResultSet rs) {
        Department department = new Department();
        try {
            department.setId(rs.getLong("id"));
            department.setName(rs.getString("name"));
            department.setCode(rs.getString("code"));
            department.setRegion(regionRepository.findOneBy("id", rs.getString("region_id")));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Department object : " + e.getMessage());
            department = null;
        }
        return department;
    }
}
