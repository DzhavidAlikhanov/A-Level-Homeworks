package ua.alikhanov.homeworks.hw2;

public class Task2 {
    public static void main(String[] args) {

        // Обьявление координат вершин треугольника
        double xA = 1.0;
        double yA = 5.0;
        double xB = 3.0;
        double yB = 5.0;
        double xC = 6.0;
        double yC = 7.0;

        // Вычисление длин сторон треугольника
        double AB = calculateDistance(xA, yA, xB, yB);
        double BC = calculateDistance(xB, yB, xC, yC);
        double CA = calculateDistance(xC, yC, xA, yA);

        // Вычисление площади треугольника
        double S = calculateTriangleArea(AB, BC, CA);

        // Вывод на консоль площади треугольника
        System.out.println("Площадь треугольника: " + S);
    }

    // Метод для вычисления расстояния между двумя точками
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Метод для вычисления площади треугольника по формуле Герона
    public static double calculateTriangleArea(double AB, double BC, double CA) {
        double s = (AB + BC + CA) / 2;
        return Math.sqrt(s * (s - AB) * (s - BC) * (s - CA));

    }
}
