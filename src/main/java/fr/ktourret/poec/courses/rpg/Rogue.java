package fr.ktourret.poec.courses.rpg;

public class Rogue extends Character {

    Rogue(String name) {
        super(name, 20, 34, 14, 0, 20, 22, 2.2, 2.8, 1.4);
        setCriticalChance(25);
        setCriticalDamageRatio(175);
    }

    @Override
    protected double getMainStats() {
        return this.getAgility();
    }

}
