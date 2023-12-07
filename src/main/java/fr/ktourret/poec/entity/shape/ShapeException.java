package fr.ktourret.poec.entity.shape;

public class ShapeException extends Exception {

    ShapeException(double width) {
        System.out.println(width + " isn't a proper width, it has to be higher than 0");
    }

}
