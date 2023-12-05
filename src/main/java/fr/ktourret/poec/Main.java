package fr.ktourret.poec;

import fr.ktourret.poec.entity.chess.*;

public class Main {

    public static void main(String[] args) {
//        (new Algo()).test();
//        (new ExoScanner()).test();
        AbstractPiece p1 = new Rook("black");
        AbstractPiece p2 = new Knight("black");
        AbstractPiece p3 = new Pawn("black");
        System.out.println(p1);
    }

    private static double getRandomBetween(int min, int max) {
        return Math.floor((Math.random() * (max - min)) + min);
    }

}