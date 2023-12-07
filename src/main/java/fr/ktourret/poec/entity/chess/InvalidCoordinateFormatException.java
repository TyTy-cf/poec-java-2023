package fr.ktourret.poec.entity.chess;

public class InvalidCoordinateFormatException extends Exception {
    InvalidCoordinateFormatException(String coordinate) {
        super(coordinate + " n'est pas un format autorisé de coordonnées");
    }
}
