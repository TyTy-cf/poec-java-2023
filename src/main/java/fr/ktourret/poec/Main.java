package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.repository.CountryRepository;
import fr.ktourret.poec.my_mvc.repository.IncompleteDAOException;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        CountryRepository cr = new CountryRepository();
//        List< Country> countries = cr.findAll();
//        for (Country c : countries) {
//            System.out.println(c);
//        }

        Country country = new Country();
        country.setName("Ukraine");
        country.setCode("ua");
        try {
            cr.save(country);
        } catch (IncompleteDAOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(country);
    }

}