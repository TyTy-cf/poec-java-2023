package fr.ktourret.poec.entity.chess;

public class Knight extends AbstractPiece {

    public Knight(String color) {
        super(color);
        image = "♘";
        if (color.equals("white")) {
            image = "♞";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis un cavalier indépendant");
    }

}
