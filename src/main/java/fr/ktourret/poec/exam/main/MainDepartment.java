package fr.ktourret.poec.exam.main;

import fr.ktourret.poec.exam.entity.geogouv.Region;
import fr.ktourret.poec.exam.repository.DepartmentRepository;
import fr.ktourret.poec.exam.repository.RegionRepository;
import fr.ktourret.poec.exam.service.Dump;

public class MainDepartment {

    public static void main(String[] args) {
        DepartmentRepository departmentRepository = new DepartmentRepository();
//        departmentRepository.findAll().forEach(Dump::dump);
//        Dump.dump(departmentRepository.findOneBy("code", "63"));

        RegionRepository regionRepository = new RegionRepository();
        Region region = regionRepository.findOneBy("code", "84");
        if (region != null) {
            departmentRepository.findByRegion(region).forEach(Dump::dump);
        }
    }

}
