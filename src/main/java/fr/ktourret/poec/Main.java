package fr.ktourret.poec;

import fr.ktourret.poec.exos.Algo;
import fr.ktourret.poec.exos.ExoScanner;

public class Main {

    public static void main(String[] args) {
//        (new Algo()).test();
        (new ExoScanner()).test();
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}