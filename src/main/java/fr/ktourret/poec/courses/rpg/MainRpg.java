package fr.ktourret.poec.courses.rpg;


public class MainRpg {

    public static void main(String[] args) {
        Character war = new War("Kevin");
        Character rogue = new Rogue("Kevin");

        while (!war.attack(rogue) && !rogue.attack(war));
        String result = "War win with " + war.getCurrentHp() + " hp remaining !";
        if (war.isDead()) {
            result = "Rogue win with " + rogue.getCurrentHp() + " hp remaining !";
        }
        System.out.println(result);
    }

}
