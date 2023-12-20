package fr.ktourret.poec.courses.rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Character {

    private String name;

    private double strength;

    private double agility;

    private double intelligence;

    private double strengthGain;

    private double agilityGain;

    private double intelligenceGain;

    private int baseArmor;

    private int armor;

    private int hp;

    private int currentHp;

    private int baseMinDamage;

    private int baseMaxDamage;

    private int minDamage;

    private int maxDamage;

    private int level = 1;

    private double criticalChance = 15;

    private double criticalDamageRatio  = 150;

    protected Character(String name, double strength, double agility, double intelligence, int baseArmor, int minDamage, int maxDamage, double strengthGain, double agilityGain ,double intelligenceGain) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        setHp();
        this.currentHp = this.hp;
        this.baseArmor = baseArmor;
        setArmor();
        this.strengthGain = strengthGain;
        this.agilityGain = agilityGain;
        this.intelligenceGain = intelligenceGain;
        this.baseMinDamage = minDamage;
        this.baseMaxDamage = maxDamage;
        setDamage();
    }

    public void levelUp() {
        this.level++;
        this.strength = getNewStat(strength, strengthGain);
        this.agility = getNewStat(agility, agilityGain);
        this.intelligence = getNewStat(intelligence, intelligenceGain);
        setHp();
        setArmor();
        this.currentHp += (int) this.strengthGain * 22;
        setDamage();
    }

    public boolean attack(Character attacked) {
        double reduction = 1 - ( (0.06 * attacked.getArmor()) / (1 + 0.06 * attacked.getArmor()));
        boolean isCriticalStrike = getRandomBetween(1, 100) <= this.criticalChance;
        double damage = getRandomBetween(this.minDamage, this.maxDamage) * reduction;
        if (isCriticalStrike) {
            damage *= (this.criticalDamageRatio / 100);
            System.out.println("Critical strike dealt !");
        }
        attacked.setCurrentHp(attacked.getCurrentHp() - (int) damage);
        return attacked.isDead();
    }

    public boolean isDead() {
        return getCurrentHp() <= 0;
    }

    protected void setDamage() {
        this.minDamage = baseMinDamage + (int) getMainStats();
        this.maxDamage = baseMaxDamage + (int) getMainStats();
    }

    protected void setArmor() {
        this.armor = (int) (baseArmor + (this.agility / 6));
    }

    protected void setHp() {
        this.hp = (int) (22 * strength) + 120;
    }

    abstract protected double getMainStats();

    private double getNewStat(double stat, double gain) {
        return BigDecimal.valueOf(stat + gain)
                .setScale(3, RoundingMode.FLOOR)
                .doubleValue();
    }

    private double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}
