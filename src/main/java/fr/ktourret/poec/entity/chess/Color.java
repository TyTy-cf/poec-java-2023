package fr.ktourret.poec.entity.chess;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    WHITE("\u001B[31m"),
    BLACK("\u001B[34m"),
    SELECTED("\u001B[43m");

    private final String color;

}
