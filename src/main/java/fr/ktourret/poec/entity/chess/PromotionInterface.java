package fr.ktourret.poec.entity.chess;

public interface PromotionInterface {

    String TOTO = "TOTO";

    boolean handlePromotion();
    
    default void test() {
        privateCall();
    }

    private void privateCall() {
        System.out.println("Inside private call");
    }

}
