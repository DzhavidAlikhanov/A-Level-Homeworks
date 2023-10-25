package ua.alikhanov.hw.hw4;

import java.util.Random;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[2000];
        fillArray(array);

        int[] modifiedArray = replaceEvenWithZeros(array);

        // Выводим первые несколько элементов измененного массива для проверки
        for (int i = 0; i < 10; i++) {
            System.out.print(modifiedArray[i] + " ");
        }
    }

    public static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1; // случайные значения от 1 до 100 включительно
        }
    }

    public static int[] replaceEvenWithZeros(int[] arr) {
        int[] modifiedArray = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < modifiedArray.length; i++) {
            if (modifiedArray[i] % 2 == 0) {
                modifiedArray[i] = 0;
            }
        }
        return modifiedArray;
    }
}