package homeworks.hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод строки с консоли
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Разделение строки на слова по пробелам
        String[] words = input.trim().split("\\s+"); // Учитываем возможные пробелы в начале и конце

        // Подсчет количества слов
        int wordCount = words.length;

        // Вывод результата
        System.out.println("Количество слов в строке: " + wordCount);

        scanner.close();
    }
}





