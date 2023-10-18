package ua.alikhanov.homeworks.hw5;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int k = 2; // Индекс элемента, который нужно удалить

        int[] newArray = removeElement(array, k);

        System.out.println("Исходный массив: " + Arrays.toString(array));
        System.out.println("Массив после удаления элемента: " + Arrays.toString(newArray));
    }

    public static int[] removeElement(int[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            return arr; // Если индекс k выходит за пределы массива, ничего не удаляем
        }
        int[] newArray = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != k) {
                newArray[j] = arr[i];
                j++;
            }
        }
        return newArray;
    }
}
