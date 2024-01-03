package fr.ktourret.poec.exam.repository;

import fr.ktourret.poec.exam.entity.geogouv.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegionRepository extends AbstractRepository<Region> {

    public RegionRepository() {
        super("region");
    }

    public int findPopulationByRegion(Region region) {
        String query =
                "SELECT SUM(city.population) AS 'population' " +
                "FROM region " +
                "JOIN department ON department.region_id = region.id " +
                "JOIN city ON city.department_id = department.id " +
                "WHERE region.id = ?;";
        return this.findPopulationByQuery(query, region.getId());
    }

    @Override
    protected Region getObject(ResultSet rs) {
        Region region = new Region();
        try {
            region.setId(rs.getLong("id"));
            region.setName(rs.getString("name"));
            region.setCode(rs.getString("code"));
        } catch (SQLException e) {
            System.out.println("Something goes wrong while creating a Region object : " + e.getMessage());
            region = null;
        }
        return region;
    }
}
