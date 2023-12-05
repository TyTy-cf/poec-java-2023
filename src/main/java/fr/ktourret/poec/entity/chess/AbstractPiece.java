package fr.ktourret.poec.entity.chess;

public abstract class AbstractPiece {

    protected String color;

    protected String image;

    protected AbstractPiece(String color) {
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

//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + " - " + color;
//    }

    public abstract void move();
}
