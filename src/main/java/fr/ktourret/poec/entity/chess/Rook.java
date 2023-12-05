package fr.ktourret.poec.entity.chess;

public class Rook extends AbstractPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public void move() {
        System.out.println("Je suis une tour indépendante");
    }
}
