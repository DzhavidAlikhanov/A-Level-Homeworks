package ua.alikhanov.hw.hw003;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки с консоли
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Подсчёт количества слов
        int wordCount = countWords(input);

        // Вывод резутьтата
        printWordCount(wordCount);

        scanner.close();

    }

    // Метод для подсчёта количества слов в строке
    public static int countWords(String input) {
        // Разделение строки на слова по пробелам с учётом возможных пробелов в начале и вконце строки
        String[] words = input.trim().split("\\s+");
        return words.length;
    }

    // Метод для вывода результата
    public static void printWordCount(int wordCount) {
        System.out.println("Количество слов в строке: " + wordCount);


    }
}





