package fr.ktourret.poec.entity.chess;

public enum Color {
    WHITE("\u001B[31m"),
    BLACK("\u001B[34m"),
    SELECTED("\u001B[43m");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
