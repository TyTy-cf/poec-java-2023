package fr.ktourret.poec.courses.rpg;

public class Mage extends Character {

    Mage(String name) {
        super(name, 20, 23, 30, 0, 21, 29, 2.4, 2.4, 3.8);
    }

    @Override
    protected double getMainStats() {
        return this.getIntelligence();
    }

}
