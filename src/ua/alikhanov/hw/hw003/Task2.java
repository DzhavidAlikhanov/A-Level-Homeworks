package ua.alikhanov.hw.hw003;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение строки с консоли
        System.out.print("Введите строку: ");
        String inputString = scanner.nextLine();

        // Удаление пробелов из строки
        String stringWithoutSpaces = removeSpaces(inputString);

        // Проверка на палиндром
        boolean isPalindrome = checkPalindrome(stringWithoutSpaces);

        // Вывод результата
        if (isPalindrome) {
            System.out.println("Является палиндромом.");
        } else {
            System.out.println("Не является палиндромом.");
        }

        scanner.close();
    }

    // Метод для удаления пробелов из строки
    public static String removeSpaces(String input) {
        return input.replaceAll("\\s", ""); // Используется регулярное выражение для удаления всех пробелов
    }

    // Метод для проверки, является ли строка палиндромом
    public static boolean checkPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString(); // Переворачиваем строку
        return input.equalsIgnoreCase(reversed); // Сравниваем исходную строку с перевернутой, игнорируя регистр
    }
}
