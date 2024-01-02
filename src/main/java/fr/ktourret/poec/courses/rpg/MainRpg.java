package fr.ktourret.poec.courses.rpg;


import fr.ktourret.poec.my_mvc.service.Dump;

import java.util.Iterator;
import java.util.List;

public class MainRpg {

    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        Character war = factory.getCharacter("War", "Kevin");
        Character rogue = factory.getCharacter("Rogue", "Kevin");

        List<Character> characterList = List.of(war, rogue);
        for (Iterator<Character> it = characterList.iterator(); it.hasNext();) {
            Dump.dump(it.next());
        }

        Iterator<Character> ite = characterList.iterator();
        while (ite.hasNext()) {
            Dump.dump(ite.next());
        }

        while (!war.attack(rogue) && !rogue.attack(war));
        String result = war.getClass().getSimpleName() + " win with " + war.getCurrentHp() + " hp remaining !";
        if (war.isDead()) {
            result = rogue.getClass().getSimpleName() + " win with " + rogue.getCurrentHp() + " hp remaining !";
        }
        System.out.println(result);
    }

}
