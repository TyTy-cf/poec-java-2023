package fr.ktourret.poec.entity.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private final List<Cell> board;

    public ChessBoard() {
        board = new ArrayList<>();
        // traitement pour créer le board...
    }

    public List<Cell> getBoard() {
        return board;
    }
}
