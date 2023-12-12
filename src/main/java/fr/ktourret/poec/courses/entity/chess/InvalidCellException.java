package fr.ktourret.poec.courses.entity.chess;

public class InvalidCellException extends Exception {
    InvalidCellException(String str) {
        super(str + " n'est pas une coordonnée autorisée par l'application");
    }
}
