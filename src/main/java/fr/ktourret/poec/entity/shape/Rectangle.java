package fr.ktourret.poec.entity.shape;

public class Rectangle extends AbstractShape {

    private double length;

    private double width;

    public Rectangle() { }

    public Rectangle(double length, double width) {
        this.width = width;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
