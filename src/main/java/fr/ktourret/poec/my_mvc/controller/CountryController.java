package fr.ktourret.poec.my_mvc.controller;

import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.service.entity.CountryService;
import fr.ktourret.poec.my_mvc.view.CountryView;

public class CountryController {

    private CountryService countryService = new CountryService();

    private CountryView countryView = new CountryView(this);

    public void index() {
        countryView.index(countryService.findAll());
    }

    public void show(Long id) {
        countryView.show(countryService.findOneBy("id", id));
    }

    public void create(Country country) {
        if (country.getName() == null) {
            countryView.create(country);
        } else {
            Country c = countryService.save(country);
            countryView.show(c);
        }
    }

}
