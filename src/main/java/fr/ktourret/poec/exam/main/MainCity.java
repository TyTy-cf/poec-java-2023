package fr.ktourret.poec.exam.main;

import fr.ktourret.poec.exam.entity.geogouv.Department;
import fr.ktourret.poec.exam.entity.geogouv.Region;
import fr.ktourret.poec.exam.repository.CityRepository;
import fr.ktourret.poec.exam.repository.DepartmentRepository;
import fr.ktourret.poec.exam.repository.RegionRepository;
import fr.ktourret.poec.exam.service.Dump;

public class MainCity {

    public static void main(String[] args) {
        CityRepository cityRepository = new CityRepository();
        cityRepository.findAll().forEach(Dump::dump);
        Dump.dump(cityRepository.findOneBy("code", "63113"));

        DepartmentRepository departmentRepository = new DepartmentRepository();
        Department department = departmentRepository.findOneBy("code", "63");
        if (department != null) {
            cityRepository.findByDepartment(department).forEach(Dump::dump);
        }

        RegionRepository regionRepository = new RegionRepository();
        Region region = regionRepository.findOneBy("code", "84");
        if (region != null) {
            cityRepository.findByRegion(region).forEach(Dump::dump);
        }
    }

}
