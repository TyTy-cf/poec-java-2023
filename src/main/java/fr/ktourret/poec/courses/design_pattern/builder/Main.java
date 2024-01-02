package fr.ktourret.poec.courses.design_pattern.builder;

import fr.ktourret.poec.my_mvc.service.Dump;

public class Main {

    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.setPizzaBuilder(new PizzaQueenBuilder());
        pizzeria.createPizza();
        Dump.dump(pizzeria.getPizza());
    }

}
