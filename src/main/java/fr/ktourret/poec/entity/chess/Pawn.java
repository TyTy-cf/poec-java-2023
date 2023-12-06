package fr.ktourret.poec.entity.chess;

public class Pawn extends AbstractPiece implements PromotionInterface {

    public Pawn(Color color) {
        super(color);
        image = "♙";
        if (color.equals(Color.WHITE)) {
            image = "♟";
        }
    }

    @Override
    public void move() {
        System.out.println("Je suis un pion indépendante");
    }

    @Override
    public boolean handlePromotion() {
        return true;
    }
}
