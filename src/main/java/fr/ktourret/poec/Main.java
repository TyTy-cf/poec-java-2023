package fr.ktourret.poec;

import fr.ktourret.poec.courses.MainExo;
import fr.ktourret.poec.my_mvc.entity.Category;
import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.entity.Publisher;
import fr.ktourret.poec.my_mvc.entity.Region;
import fr.ktourret.poec.my_mvc.repository.CategoryRepository;
import fr.ktourret.poec.my_mvc.repository.CountryRepository;
import fr.ktourret.poec.my_mvc.repository.PublisherRepository;
import fr.ktourret.poec.my_mvc.repository.RegionRepository;
import fr.ktourret.poec.my_mvc.service.Dump;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        new MainExo();
//        CountryRepository cr = new CountryRepository();
//        CategoryRepository cr = new CategoryRepository();
//        Category c = cr.findOneBy("slug", "toto");
//        if (c != null) {
//            System.out.println(cr.delete(c));
//        }
//
//        RegionRepository repository = new RegionRepository();
//        Region region = new Region(null, "Corse", "94");
//        repository.save(region);
        PublisherRepository publisherRepository = new PublisherRepository();
        CountryRepository cr = CountryRepository.getInstance();

//        publisherRepository.findAll().forEach(Dump::dump);
        publisherRepository.findAll();

    }

}