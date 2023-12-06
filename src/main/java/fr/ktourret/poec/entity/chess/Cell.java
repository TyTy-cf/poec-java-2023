package fr.ktourret.poec.entity.chess;

public class Cell {

    private static long ID = 1L;

    private int y;

    private char x;

    private String color;

    private AbstractPiece piece;

    private long id;

    public Cell(int y, char x) {
        this.y = y;
        this.x = x;
        this.setId();
    }

    public Cell(int y, char x, String color, AbstractPiece piece) {
        this.y = y;
        this.x = x;
        this.color = color;
        this.piece = piece;
        this.setId();
    }

    public long getId() {
        return id;
    }

    private void setId() {
        this.id = Cell.ID;
        Cell.ID++;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AbstractPiece getPiece() {
        return piece;
    }

    public void setPiece(AbstractPiece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        return "" + this.x + this.y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            return this.id == ((Cell) obj).getId();
        }
        return false;
    }
}