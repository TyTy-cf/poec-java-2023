package fr.ktourret.poec.entity.chess;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractPiece {

    private static long ID = 1L;

    protected Color color;

    protected String image;

    protected long id;

    protected AbstractPiece(Color color) {
        this.id = AbstractPiece.ID;
        AbstractPiece.ID++;
        this.color = color;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractPiece) {
            return this.id == ((AbstractPiece) obj).getId();
        }
        return false;
    }

    public abstract void move();
}
