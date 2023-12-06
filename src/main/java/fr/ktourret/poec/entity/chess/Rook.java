package fr.ktourret.poec.entity.chess;

import java.util.Objects;

public class Rook extends AbstractPiece {

    public Rook(String color) {
        super(color);
        image = "♖";
        if (color.equals("white")) {
            image = "♜";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis une tour indépendante");
    }
}
