package ua.alikhanov.hw.hw011;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Square square = new Square(4.0);
        Triangle triangle = new Triangle(3.0, 4.0, 5.0, 6.0, 4.0, 60.0);

        double circlePerimeter = circle.perimeter();
        double circleArea = circle.area();

        double squarePerimeter = square.perimeter();
        double squareArea = square.area();

        double triangleHeronArea = triangle.areaHeron();
        double triangleSineArea = triangle.areaSine();
        double triangleBaseHeihtArea = triangle.areaBaseHeight();

        System.out.println("Circle Perimeter: " + circlePerimeter);
        System.out.println("Circle Area: " + circleArea);
        System.out.println(" ");
        System.out.println("Square Perimeter: " + squarePerimeter);
        System.out.println("Square Area: " + squareArea);
        System.out.println(" ");
        System.out.println("Triangle Heron Area: " + triangleHeronArea);
        System.out.println("Triangle Sine Area: " + triangleSineArea);
        System.out.println("Triangle Base Height Area: " + triangleBaseHeihtArea);

    }
}

