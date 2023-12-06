package fr.ktourret.poec.entity.chess;

import java.util.ArrayList;
import java.util.List;

public class ChessBoard {

    private final List<Cell> board;

    public ChessBoard() {
        board = new ArrayList<>();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        Color color = Color.WHITE;
        for (int y = 8; y >= 1 ; y--) {
            for (char x : chars) {
                board.add(new Cell(y, x, color, getPiece(x, y)));

                if (x != 'h') {
                    color = color == Color.WHITE ? Color.BLACK : Color.WHITE;
                }
            }
        }
        System.out.println(board);
    }

    private AbstractPiece getPiece(char x, int y) {
        AbstractPiece piece = null;
        if (y == 1 || y == 2 || y == 7 || y == 8) {
            Color colorPiece = Color.BLACK;
            if (y == 1 || y == 2) {
                colorPiece = Color.WHITE;
            }
            if ((x == 'h' || x == 'a') && (y == 1 || y == 8)) {
                piece = new Rook(colorPiece);
            }
            if ((x == 'g' || x == 'b') && (y == 1 || y == 8)) {
                piece = new Knight(colorPiece);
            }
        }
        return piece;
    }

    public Cell getCellFromXY(char x, int y) {
        for (Cell cell : board) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
    }

    public List<Cell> getBoard() {
        return board;
    }
}
