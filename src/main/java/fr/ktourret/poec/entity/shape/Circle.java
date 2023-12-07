package fr.ktourret.poec.entity.shape;

public class Circle extends AbstractShape {

    private double radius;

    public Circle(double radius) throws ShapeException {
        if (radius <= 0) {
            throw new ShapeException(radius);
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}
