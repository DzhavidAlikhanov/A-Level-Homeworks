package ua.alikhanov.homeworks.hw2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberA = getUserInput(scanner, "Введите первое число: ");
        int numberB = getUserInput(scanner, "Введите второе число: ");
        int numberC = getUserInput(scanner, "Введите третье число: ");


        int minAbsoluteValue = getMinAbsoluteValue(numberA, numberB, numberC);

        printResult(minAbsoluteValue);

        scanner.close();

    }

    public static int getUserInput(Scanner scanner, String promt) {
        System.out.println(promt);
        return scanner.nextInt();
    }

    public static int getMinAbsoluteValue(int a, int b, int c) {
        int absoluteA = Math.abs(a);
        int absoluteB = Math.abs(b);
        int absoluteC = Math.abs(c);

        return Math.min(Math.min(absoluteA, absoluteB), absoluteC);
    }

    public static void printResult(int minAbsoluteValue) {
        System.out.println("Наименьшее по модулю исло: " + minAbsoluteValue);
    }
}
