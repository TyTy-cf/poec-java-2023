package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.repository.CountryRepository;
import fr.ktourret.poec.my_mvc.service.Dump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        CountryRepository cr = new CountryRepository();
        List<Country> countries = cr.findAll();

//        countries.forEach(Dump::dump); // identique à code suivant
////        countries.forEach(c -> {
////            Dump.dump(c);
////        });
//
//        Country country = cr.findOneBy("code", "ca");
//        if (country != null) {
//            cr.delete(country);
//        }
//        Dump.dump(country);

//        System.out.println(country);
//        List< Country> countries = cr.findAll();
//        for (Country c : countries) {
//            System.out.println(c);
//        }

//        Country country = new Country();
//        country.setName("Ukraine");
//        country.setCode("ua");
//        try {
//            cr.save(country);
//        } catch (IncompleteDAOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println(country);
    }

}