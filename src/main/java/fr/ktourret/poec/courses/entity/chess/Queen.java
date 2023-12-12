package fr.ktourret.poec.courses.entity.chess;

public class Queen extends AbstractPiece {
    public Queen(Color color) {
        super(color);
        image = "Q";
    }

    @Override
    public void move() {
        System.out.println("Je suis une reine indépendante");
    }

}
