package ua.alikhanov.hw.hw014;

public class Triangle extends Figure {
    private final double side1;
    private final double side2;
    private final double side3;
    private final double base;
    private final double height;
    private final double corner;

    public Triangle(double side1, double side2, double side3, double base, double height, double corner) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0 || base <= 0 || height <= 0 || corner <= 0) {
            throw new InvalidFigureParametersException("Стороны треугольника, основание, высота или угол должны быть больше нуля.");
        }

        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new InvalidFigureParametersException("Предоставленные стороны не образуют треугольник.");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.base = base;
        this.height = height;
        this.corner = corner;
    }

    @Override
    public double area() {
        return areaHeron();
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    public double areaHeron() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double areaSine() {
        double angle = Math.toRadians(corner);
        return 0.5 * side1 * side2 * Math.sin(angle);
    }

    public double areaBaseHeight() {
        return 0.5 * base * height;
    }
}
