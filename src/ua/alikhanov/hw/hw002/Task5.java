package ua.alikhanov.hw.hw002;

import java.util.Scanner; // Импортируем класс Scanner для ввода с клавиатуры.

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создаем объект Scanner для считывания ввода пользователя.

        System.out.print("Введите число: ");
        int number = scanner.nextInt(); // Считываем введенное число и сохраняем его в переменной number.

        int reversedNumber = reverseNumber(number); // Вызываем метод reverseNumber для обращения числа.

        System.out.println("Число в обратном порядке: " + reversedNumber); // Выводим результат.

        scanner.close(); // Закрываем объект Scanner.
    }

    public static int reverseNumber(int number) {
        int reversedNumber = 0; // Инициализируем переменную для хранения обратного числа.

        while (number != 0) { // Пока число не станет равным нулю:
            int digit = number % 10; // Получаем последнюю цифру числа.
            reversedNumber = reversedNumber * 10 + digit; // Добавляем цифру в обратное число.
            number /= 10; // Удаляем последнюю цифру из исходного числа.
        }

        return reversedNumber; // Возвращаем обратное число.
    }
}