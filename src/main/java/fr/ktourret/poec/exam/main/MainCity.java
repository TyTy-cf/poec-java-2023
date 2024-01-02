package fr.ktourret.poec.exam.main;

import fr.ktourret.poec.exam.repository.CityRepository;
import fr.ktourret.poec.exam.repository.RegionRepository;
import fr.ktourret.poec.exam.service.Dump;

public class MainCity {

    public static void main(String[] args) {
        CityRepository cityRepository = new CityRepository();
        cityRepository.findAll().forEach(Dump::dump);
        Dump.dump(cityRepository.findOneBy("code", "63113"));
    }

}
