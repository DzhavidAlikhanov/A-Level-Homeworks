package homeworks.hw2;

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
        double AB = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
        double BC = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));
        double CA = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));


        // Вычисление полупериметра
        double s = (AB + BC + CA) / 2;

        // Вычисление площади треугольника по формуле Герона
        double S = Math.sqrt(s * (s - AB) * (s - BC) * (s - CA));

        // Вывод на консоль площади треугольника
        System.out.println("Площадь треугольника: " + S);
    }
}
