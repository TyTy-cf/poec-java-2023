package fr.ktourret.poec.my_mvc.view;

import fr.ktourret.poec.my_mvc.controller.CountryController;
import fr.ktourret.poec.my_mvc.entity.instant_faking.Country;
import fr.ktourret.poec.my_mvc.service.Dump;

import java.util.List;
import java.util.Scanner;

public class CountryView {

    private final Scanner sc = new Scanner(System.in);

    private CountryController cc;

    public CountryView(CountryController cc) {
        this.cc = cc;
    }

    public void index(List<Country> countries) {
        countries.forEach(Dump::dump);
    }

    public void show(Country country) {
        Dump.dump(country);
    }

    public void create(Country country) {
        System.out.println("Quel est le nom du pays ?");
        country.setName(sc.nextLine());
        System.out.println("Quel est le code du pays ?");
        country.setCode(sc.nextLine());
        System.out.println("Quel est la nationalité du pays ?");
        country.setNationality(sc.nextLine());
        cc.create(country);
    }
}
