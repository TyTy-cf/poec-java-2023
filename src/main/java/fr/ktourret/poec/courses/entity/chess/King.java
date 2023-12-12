package fr.ktourret.poec.courses.entity.chess;

public class King extends AbstractPiece {

    public King(Color color) {
        super(color);
        image = "K";
    }

    @Override
    public void move() {
        System.out.println("Je suis un roi indépendant");
    }

}
