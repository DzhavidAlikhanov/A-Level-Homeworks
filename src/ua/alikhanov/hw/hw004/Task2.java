package ua.alikhanov.hw.hw004;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[1000];
        fillArray(array);

        int countPrimes = countPrimeNumbers(array);

        System.out.println("Количество простых чисел в массиве: " + countPrimes);
    }

    public static void fillArray(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1; // случайные значения от 1 до 100 включительно
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeNumbers(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
}