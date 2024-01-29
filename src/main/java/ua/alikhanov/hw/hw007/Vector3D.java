package ua.alikhanov.hw.hw007;

import java.util.Random;

public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Вычисление длины вектора
    public double calculateLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Векторное произведение с другим вектором
    public Vector3D vectorProduct(Vector3D other) {
        double newX = y * other.z - z * other.y;
        double newY = z * other.x - x * other.z;
        double newZ = x * other.y - y * other.x;
        return new Vector3D(newX, newY, newZ);
    }

    // Вычисление косинуса угла между векторами
    public double calculateCosineAngle(Vector3D other) {
        double dotProduct = x * other.x + y * other.y + z * other.z;
        double thisLength = calculateLength();
        double otherLength = other.calculateLength();
        return dotProduct / (thisLength * otherLength);
    }

    // Методы для суммы и разности векторов
    public Vector3D add(Vector3D other) {
        double newX = x + other.x;
        double newY = y + other.y;
        double newZ = z + other.z;
        return new Vector3D(newX, newY, newZ);
    }

    public Vector3D subtract(Vector3D other) {
        double newX = x - other.x;
        double newY = y - other.y;
        double newZ = z - other.z;
        return new Vector3D(newX, newY, newZ);
    }

    // Генерация массива случайных векторов
    public static Vector3D[] generateRandomVectors(int n) {
        Vector3D[] vectors = new Vector3D[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double z = random.nextDouble();
            vectors[i] = new Vector3D(x, y, z);
        }
        return vectors;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
