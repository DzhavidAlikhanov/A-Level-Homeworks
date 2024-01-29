package ua.alikhanov.hw.hw011;


public class Square extends Figure {
    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new InvalidFigureParametersException("Сторона квадрата должна быть больше нуля.");
        }

        this.side = side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
