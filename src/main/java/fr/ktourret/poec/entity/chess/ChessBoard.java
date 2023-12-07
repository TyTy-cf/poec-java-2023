package fr.ktourret.poec.entity.chess;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            if ((x == 'c' || x == 'f') && (y == 1 || y == 8)) {
                piece = new Bishop(colorPiece);
            }
            if (x == 'd' && (y == 1 || y == 8)) {
                piece = new Queen(colorPiece);
            }
            if (x == 'e' && (y == 1 || y == 8)) {
                piece = new King(colorPiece);
            }
            if (y == 2 || y == 7) {
                piece = new Pawn(colorPiece);
            }
        }
        return piece;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this);

        String str = sc.nextLine();
        System.out.println(str);

        String[] coordinates = str.split(" ");
        if (coordinates.length == 1) {
            System.out.println("Erreur de formattage des coordonnées");
            return;
        }
        if (!coordinates[0].matches("[a-h]")) {
            System.out.println("La coordonnée en X doit être un seul caractère compris entre a et h");
            return;
        }
        if (!coordinates[1].matches("[1-8]")) {
            System.out.println("La coordonnée en Y doit être un seul chiffre compris entre 1 et 8");
            return;
        }

        char x = coordinates[0].charAt(0);
        int y = Integer.parseInt(coordinates[1]);
        Cell selectedCell = getCellFromXY(x, y);

        System.out.println(selectedCell);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        sb.append("  ");
        // Ajoute les lettre pour les colonnes
        for (char c : chars) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }
        sb.append("\n");
        int currentLine = 0;
        for (int i = 0; i < board.size(); i++) {
            Cell cell = board.get(i);
            if (currentLine != cell.getY()) {
                currentLine = cell.getY();
            }
            if (i%8 == 0) {
                sb.append(currentLine);
                sb.append(" ");
            }
            sb.append(cell);
            if (i%8 == 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
