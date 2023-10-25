package ua.alikhanov.hw.hw5;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};

        boolean isOrdered = checkIfOrdered(array);

        System.out.println("Массив упорядочен по убыванию: " + isOrdered);
    }

    public static boolean checkIfOrdered(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
