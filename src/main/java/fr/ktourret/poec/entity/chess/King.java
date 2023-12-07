package fr.ktourret.poec.entity.chess;

public class King extends AbstractPiece {
    public King(Color color) {
        super(color);
        image = "♔";
        if (color.equals(Color.WHITE)) {
            image = "♚";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis un roi indépendant");
    }

}
