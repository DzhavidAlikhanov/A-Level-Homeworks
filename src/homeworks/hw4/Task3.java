package homeworks.hw4;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        fillArray(array);

        replaceEvenWithZeros(array);

        // Выводим первые несколько элементов массива для проверки
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1; // случайные значения от 1 до 100 включительно
        }
    }

    public static void replaceEvenWithZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            }
        }
    }
}