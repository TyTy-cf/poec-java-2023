package fr.ktourret.poec.entity.chess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cell {

    private static long ID = 1L;

    private int y;

    private char x;

    private Color color;

    private AbstractPiece piece;

    private boolean isSelected = false;

    private long id;

    public Cell(int y, char x, Color color) {
        this.y = y;
        this.x = x;
        this.color = color;
        this.setId();
    }

    public Cell(int y, char x, Color color, AbstractPiece piece) {
        this.y = y;
        this.x = x;
        this.color = color;
        this.piece = piece;
        this.setId();
    }

    private void setId() {
        this.id = Cell.ID;
        Cell.ID++;
    }

    public boolean hasPiece() {
        return piece != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.isSelected) {
            sb.append(Color.SELECTED.getColor());
        } else if (this.color == Color.BLACK) {
            sb.append("\u001B[40m");
        } else {
            sb.append("\u001B[47m");
        }
        if (this.piece != null) {
            sb.append(" ").append(this.getPiece().getColor().getColor()).append(this.piece.getImage()).append(" ");
        } else {
            sb.append("   ");
        }
        sb.append("\u001B[0m");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            return this.id == ((Cell) obj).getId();
        }
        return false;
    }
}
