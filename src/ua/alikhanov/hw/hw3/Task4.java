package ua.alikhanov.hw.hw3;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Минимальное значение диапазона
        int maxRange = 100; // Максимальное значение диапазона
        int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange; // Генерация случайного числа

        int attempts = 0; // Количество попыток

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        System.out.println("Я загадал число от " + minRange + " до " + maxRange + ". Попробуйте угадать.");

        while (true) {
            System.out.print("Введите вашу догадку: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < minRange || userGuess > maxRange) {
                System.out.println("Пожалуйста, введите число в диапазоне от " + minRange + " до " + maxRange);
            } else if (userGuess < secretNumber) {
                System.out.println("Мало. Попробуйте еще раз.");
            } else if (userGuess > secretNumber) {
                System.out.println("Много. Попробуйте еще раз.");
            } else {
                System.out.println("Поздравляю! Вы угадали число " + secretNumber + " с " + attempts + " попытки.");
                break; // Выход из цикла при угадывании числа
            }
        }

        scanner.close();
    }
}