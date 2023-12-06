package fr.ktourret.poec.entity.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private final List<Cell> board;

    public ChessBoard() {
        board = new ArrayList<>();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int y = 8; y >= 1 ; y--) {
            for (char x : chars) {
                System.out.println(x + "-" + y);
            }
        }
    }

    public List<Cell> getBoard() {
        return board;
    }
}
