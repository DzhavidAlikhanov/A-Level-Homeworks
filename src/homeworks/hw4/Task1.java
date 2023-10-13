package homeworks.hw4;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[400];
        fillArray(array);

        double averageArithmetic = calculateAverageArithmetic(array);
        double averageGeometric = calculateAverageGeometric(array);

        System.out.println("Среднее арифметическое: " + averageArithmetic);
        System.out.println("Среднее геометрическое: " + averageGeometric);
    }

    public static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10) + 1; // случайные значения от 1 до 10 включительно
        }
    }

    public static double calculateAverageArithmetic(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static double calculateAverageGeometric(int[] arr) {
        double product = 1.0;
        for (int num : arr) {
            product *= num;
        }
        return Math.pow(product, 1.0 / arr.length);
    }
}