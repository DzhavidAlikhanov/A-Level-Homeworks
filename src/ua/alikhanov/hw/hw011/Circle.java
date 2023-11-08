package ua.alikhanov.hw.hw011;

public class Circle extends Figure {
    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new InvalidFigureParametersException("Радиус круга должен быть больше нуля.");
        }
        this.radius = radius;

    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
