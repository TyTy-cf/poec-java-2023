package fr.ktourret.poec.entity.chess;

public abstract class AbstractPiece {

    private static long ID = 1L;

    protected String color;

    protected String image;

    protected long id;

    protected AbstractPiece(String color) {
        this.id = AbstractPiece.ID;
        AbstractPiece.ID++;
        this.color = color;
        this.image = "/resources/chess/" + getClass().getSimpleName().toLowerCase() + "-" + color + ".png";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
