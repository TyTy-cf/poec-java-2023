package fr.ktourret.poec.courses.design_pattern.builder;

public class PizzaQueenBuilder extends PizzaTomatoesBuilder {

    @Override
    public void buildDough() {
        pizza.setDough("thin");
    }

    @Override
    public void buildIngredients() {
        pizza.setIngredients("jambon+emmental");
    }
}
