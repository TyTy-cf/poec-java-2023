package fr.ktourret.poec.entity.chess;

public class Rook extends AbstractPiece {

    public Rook(Color color) {
        super(color);
        image = "R";
    }

    @Override
    public void move() {
        System.out.println("Je suis une tour indépendante");
    }
}
