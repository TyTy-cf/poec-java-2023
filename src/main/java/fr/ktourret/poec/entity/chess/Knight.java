package fr.ktourret.poec.entity.chess;

public class Knight extends AbstractPiece {

    public Knight(Color color) {
        super(color);
        image = "N";
    }

    @Override
    public void move() {
        System.out.println("Je suis un cavalier indépendant");
    }

}
