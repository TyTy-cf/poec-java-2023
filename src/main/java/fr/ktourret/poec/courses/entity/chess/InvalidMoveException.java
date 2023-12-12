package fr.ktourret.poec.courses.entity.chess;

public class InvalidMoveException extends Exception {

    InvalidMoveException() {
        super("Illegal move");
    }

}
