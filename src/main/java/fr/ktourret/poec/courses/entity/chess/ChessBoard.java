package fr.ktourret.poec.courses.entity.chess;

import fr.ktourret.poec.courses.entity.example.ChessFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class ChessBoard {

    private final List<Cell> board;

    private List<AbstractPiece> deadPieces = new ArrayList<>();

    private int nbTurns = 1;

    private Cell selectedCell;

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
                piece = ChessFactory.getPiece(Rook.class.getSimpleName(), colorPiece);
            }
            if ((x == 'g' || x == 'b') && (y == 1 || y == 8)) {
                piece = ChessFactory.getPiece(Knight.class.getSimpleName(), colorPiece);
            }
            if ((x == 'c' || x == 'f') && (y == 1 || y == 8)) {
                piece = ChessFactory.getPiece(Bishop.class.getSimpleName(), colorPiece);
            }
            if (x == 'd' && (y == 1 || y == 8)) {
                piece = ChessFactory.getPiece(Queen.class.getSimpleName(), colorPiece);
            }
            if (x == 'e' && (y == 1 || y == 8)) {
                piece = ChessFactory.getPiece(King.class.getSimpleName(), colorPiece);
            }
            if (y == 2 || y == 7) {
                piece = ChessFactory.getPiece(Pawn.class.getSimpleName(), colorPiece);
            }
        }
        return piece;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println(this);
        System.out.println("Tour n°" + nbTurns);
        String str = sc.nextLine();

        while (!str.equals("ff")) {
            try {
                String[] coordinates = str.split(" ");
                if (coordinates.length == 1) {
                    throw new InvalidCoordinateFormatException(str);
                }
                if (!coordinates[0].matches("[a-h]") || !coordinates[1].matches("[1-8]")) {
                    throw new InvalidCellException(str);
                }

                char x = coordinates[0].charAt(0);
                int y = Integer.parseInt(coordinates[1]);
                Cell tmp = getCellFromXY(x, y);

                if (tmp.hasPiece() && selectedCell == null) {
                    selectedCell = tmp;
                    selectedCell.setSelected(!selectedCell.isSelected());
                } else if (selectedCell == tmp) {
                    selectedCell.setSelected(!selectedCell.isSelected());
                    selectedCell = null;
                } else {
                    if (tmp.hasPiece() && tmp.getPiece().getColor().equals(selectedCell.getPiece().getColor())) {
                        throw new InvalidMoveException();
                    }
                    selectedCell.setSelected(!selectedCell.isSelected());
                    if (tmp.hasPiece()) {
                        deadPieces.add(tmp.getPiece());
                    }
                    tmp.setPiece(selectedCell.getPiece());
                    selectedCell.setPiece(null);
                    selectedCell = null;
                    nbTurns++;
                    System.out.println("Il y a " + deadPieces.size() + " pièces mangée(s)");
                    System.out.println("Tour n°" + nbTurns);
                }

            } catch (InvalidCoordinateFormatException | InvalidCellException | InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(this);
            str = sc.nextLine();
        }
    }

    public Cell getCellFromXY(char x, int y) {
        for (Cell cell : board) {
            if (cell.getX() == x && cell.getY() == y) {
                return cell;
            }
        }
        return null;
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
