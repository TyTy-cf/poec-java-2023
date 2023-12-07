package fr.ktourret.poec.entity.chess;

public class Bishop extends AbstractPiece {

    public Bishop(Color color) {
        super(color);
        image = "B";
    }

    @Override
    public void move() {
        System.out.println("Je suis un fou indépendant");
    }

}
