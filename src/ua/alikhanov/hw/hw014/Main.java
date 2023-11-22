package ua.alikhanov.hw.hw014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        double triangleBaseHeightArea = triangle.areaBaseHeight();

        System.out.println("Circle Perimeter: " + circlePerimeter);
        System.out.println("Circle Area: " + circleArea);
        System.out.println(" ");
        System.out.println("Square Perimeter: " + squarePerimeter);
        System.out.println("Square Area: " + squareArea);
        System.out.println(" ");
        System.out.println("Triangle Heron Area: " + triangleHeronArea);
        System.out.println("Triangle Sine Area: " + triangleSineArea);
        System.out.println("Triangle Base Height Area: " + triangleBaseHeightArea);


        List<Figure> figures = new ArrayList<>();
        figures.add(circle);
        figures.add(square);
        figures.add(triangle);

        Comparator<Figure> areaComparator = Comparator.comparingDouble(Figure::area);
        Comparator<Figure> perimeterComparator = Comparator.comparingDouble(Figure::perimeter);

        Comparator<Figure> combinedComparator = areaComparator.thenComparing(perimeterComparator);


        Figure foundFigure = findFigure(figures, 5.0);
        if (foundFigure != null) {
            System.out.println("\nFound Figure: Area = " + foundFigure.area() + ", Perimeter = " + foundFigure.perimeter());
        } else {
            System.out.println("\nNo Figure found.");
        }


        Figure foundFigure2 = findFigureWithAreaTwicePerimeter(figures);
        if (foundFigure2 != null) {
            System.out.println("\nFound Figure with Area Twice Perimeter: Area = " + foundFigure2.area() + ", Perimeter = " + foundFigure2.perimeter());
        } else {
            System.out.println("\nNo Figure found with Area Twice Perimeter.");
        }
    }

    private static Figure findFigure(List<Figure> figures, double difference) {
        return figures.stream()
                .min(Comparator.comparingDouble(Figure::area))
                .filter(figure -> figure.area() > (figure.area() - difference))
                .orElse(null);
    }

    private static Figure findFigureWithAreaTwicePerimeter(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.area() > 2 * figure.perimeter())
                .findFirst()
                .orElse(null);
    }
}
