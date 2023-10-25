package ua.alikhanov.hw.hw5;

public class Task1 {
    public static void main(String[] args) {
        int n = 4; // Размерность массива
        int[][] array = fillArray(n);

        printArray(array);
    }

    public static int[][] fillArray(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (i % 2 == 0) ? count : -count;
                count++;
            }
        }
        return arr;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}