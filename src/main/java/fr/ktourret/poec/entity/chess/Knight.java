package fr.ktourret.poec.entity.chess;

public class Knight extends AbstractPiece {

    public Knight(Color color) {
        super(color);
        image = "♘";
        if (color.equals(Color.WHITE)) {
            image = "♞";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis un cavalier indépendant");
    }

}
