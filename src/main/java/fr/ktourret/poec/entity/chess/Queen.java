package fr.ktourret.poec.entity.chess;

public class Queen extends AbstractPiece {
    public Queen(Color color) {
        super(color);
        image = "♕";
        if (color.equals(Color.WHITE)) {
            image = "♛";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis une reine indépendante");
    }

}
