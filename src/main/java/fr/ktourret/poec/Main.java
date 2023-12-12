package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.repository.CountryRepository;

public class Main {

    public static void main(String[] args) {
        CountryRepository cr = new CountryRepository();
        cr.findAll();
    }

}