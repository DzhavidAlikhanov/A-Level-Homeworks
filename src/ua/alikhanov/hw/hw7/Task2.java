package ua.alikhanov.hw.hw7;

public class Task2 {
    public static void main(String[] args) {
        Vector3D vector1 = new Vector3D(1.0, 2.0, 3.0);
        Vector3D vector2 = new Vector3D(4.0, 5.0, 6.0);

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2);
        System.out.println("Длина Вектора 1: " + vector1.calculateLength());
        System.out.println("Длина Вектора 2: " + vector2.calculateLength());
        System.out.println("Вектор 1 + Вектор 2: " + vector1.add(vector2));
        System.out.println("Вектор 1 - Вектор 2: " + vector1.subtract(vector2));
        System.out.println("Вектор 1 х Вектор 2 (Векторное произведение): " + vector1.vectorProduct(vector2));
        System.out.println("Косинус угла между Вектором 1 и Вектором 2: " + vector1.calculateCosineAngle(vector2));

        Vector3D[] randomVectors = Vector3D.generateRandomVectors(3);
        System.out.println("Случайные Векторы: ");
        for (Vector3D vector : randomVectors) {
            System.out.println(vector);
        }
    }
}
