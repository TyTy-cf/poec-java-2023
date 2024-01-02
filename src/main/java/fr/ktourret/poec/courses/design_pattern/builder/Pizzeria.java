package fr.ktourret.poec.courses.design_pattern.builder;

public class Pizzeria { // Director

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder builder) {
        this.pizzaBuilder = builder;
    }

    public void createPizza() {
        pizzaBuilder.createPizza();
        pizzaBuilder.buildBase();
        pizzaBuilder.buildDough();
        pizzaBuilder.buildIngredients();
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

}
