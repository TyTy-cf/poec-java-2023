package fr.ktourret.poec.entity.chess;

public class InvalidMoveException extends Exception {

    InvalidMoveException() {
        super("Illegal move");
    }

}
