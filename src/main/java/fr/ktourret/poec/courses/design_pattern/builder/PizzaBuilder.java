package fr.ktourret.poec.courses.design_pattern.builder;

public abstract class PizzaBuilder {

    protected Pizza pizza;

    public void createPizza() {
        this.pizza = new Pizza();
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public abstract void buildDough();

    public abstract void buildBase();

    public abstract void buildIngredients();

}
