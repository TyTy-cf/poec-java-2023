package fr.ktourret.poec.exam.main;

import fr.ktourret.poec.exam.entity.geogouv.Region;
import fr.ktourret.poec.exam.repository.RegionRepository;
import fr.ktourret.poec.exam.service.Dump;

public class MainRegion {

    public static void main(String[] args) {
        RegionRepository regionRepository = new RegionRepository();
        regionRepository.findAll().forEach(Dump::dump);
        Dump.dump(regionRepository.findOneBy("code", "84"));

        Region region = regionRepository.findOneBy("code", "84");
        if (region != null) {
            System.out.println(regionRepository.findPopulationByRegion(region));
        }
    }

}
