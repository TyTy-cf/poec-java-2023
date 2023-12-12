package fr.ktourret.poec.courses.entity.example;

import fr.ktourret.poec.courses.entity.chess.*;
import fr.ktourret.poec.entity.chess.*;

public class ChessFactory {

    public static AbstractPiece getPiece(String name, Color color) {
        if (name.isEmpty()) {
            return null;
        }

        if (name.equalsIgnoreCase("rook")) {
            return new Rook(color);
        }

        if (name.equalsIgnoreCase("pawn")) {
            return new Pawn(color);
        }

        if (name.equalsIgnoreCase("queen")) {
            return new Queen(color);
        }

        if (name.equalsIgnoreCase("king")) {
            return new King(color);
        }

        if (name.equalsIgnoreCase("bishop")) {
            return new Bishop(color);
        }

        if (name.equalsIgnoreCase("knight")) {
            return new Knight(color);
        }

        return null;
    }

}
