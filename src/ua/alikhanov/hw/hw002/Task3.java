package ua.alikhanov.hw.hw002;

import java.util.Scanner;


public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner для считывания данных с консоли.

        while (true) { // Бесконечный цикл для повторения ввода чисел.
            System.out.print("Введите число (для выхода введите отрицательное число): "); // Вывод приглашения для ввода числа.
            int number = scanner.nextInt(); // Считывание числа с клавиатуры и сохранение его в переменной number.

            if (number < 0) { // Проверка, является ли введенное число отрицательным.
                System.out.println("Выход из программы."); // Вывод сообщения "Выход из программы."
                break; // Выход из цикла при вводе отрицательного числа
            }
            printEvenOrOdd(number); // Вызов метода для вывода информации о четности/нечетности числа.
        }

        scanner.close();
    }

    public static void printEvenOrOdd(int number) {

        if (isEven(number)) {
            System.out.println(number + " - четное число"); // Вывод сообщения о том, что число четное.
        } else {
            System.out.println(number + " - нечетное число"); // Вывод сообщения о том, что число нечетное.
        }
    }


    public static boolean isEven(int number) {

        return number % 2 == 0; //Проверка, является ли число четным, и возвращение результата.
    }
}

