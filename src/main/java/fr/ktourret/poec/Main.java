package fr.ktourret.poec;

import fr.ktourret.poec.my_mvc.controller.CountryController;
import fr.ktourret.poec.my_mvc.entity.Country;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Où veux tu aller ?");
        String goTo = sc.nextLine();
        CountryController countryController = new CountryController();
        while (!goTo.isEmpty()) {
            if (goTo.equals("index")) {
                countryController.index();
            }
            if (goTo.equals("show")) {
                countryController.show(sc.nextLong());
            }
            if (goTo.equalsIgnoreCase("create")) {
                countryController.create(new Country());
            }
            if (goTo.equalsIgnoreCase("q")) {
                return;
            }
            goTo = sc.nextLine();
        }
    }

}