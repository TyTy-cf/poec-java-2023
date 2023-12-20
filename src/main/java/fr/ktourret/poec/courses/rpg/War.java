package fr.ktourret.poec.courses.rpg;

public class War extends Character {

    War(String name) {
        super(name, 24, 18, 18, 2, 25, 29, 3.2, 1.4, 1.8);
    }

    @Override
    protected double getMainStats() {
        return this.getStrength();
    }

}
