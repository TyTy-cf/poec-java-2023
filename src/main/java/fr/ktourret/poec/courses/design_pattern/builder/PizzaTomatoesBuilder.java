package fr.ktourret.poec.courses.design_pattern.builder;

public abstract class PizzaTomatoesBuilder extends PizzaBuilder {

    @Override
    public void buildBase() {
        pizza.setBase("tomatoes");
    }

}
