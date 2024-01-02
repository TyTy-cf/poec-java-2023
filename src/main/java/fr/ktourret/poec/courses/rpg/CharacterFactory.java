package fr.ktourret.poec.courses.rpg;

public class CharacterFactory {

    public Character getCharacter(String type, String name) {
        if (type.equals(Mage.class.getSimpleName())) {
            return new Mage(name);
        }
        if (type.equals(War.class.getSimpleName())) {
            return new War(name);
        }
        if (type.equals(Rogue.class.getSimpleName())) {
            return new Rogue(name);
        }
        return null;
    }

}
