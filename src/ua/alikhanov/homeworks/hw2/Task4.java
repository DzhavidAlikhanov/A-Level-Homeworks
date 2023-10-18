package ua.alikhanov.homeworks.hw2;

import java.util.Scanner; // Импорт класса Scanner(сканер) для ввода с клавиатуры.

public class Task4 {
    public static void main(String[] args) {
        // Создание объекта Scanner для считывания данных с консоли.
        Scanner scanner = new Scanner(System.in);
        // Вывод предложения для ввода первого числа.
        System.out.print("Введите первое число: ");
        // Считывание первого числа с клавиатуры и сохранение его в переменной.
        int numberA = scanner.nextInt();
        // Вывод предложения для ввода первого числа.
        System.out.print("Введите второе число: ");
        // Считывание второго числа с клавиатуры и сохранение его в переменной.
        int numberB = scanner.nextInt();
        // Вывод предложения для ввода первого числа.
        System.out.print("Введите третье число: ");
        // Считывание третьего числа с клавиатуры и сохранение его в переменной.
        int numberC = scanner.nextInt();


        // Вывод предложения для ввода первого числа.
        int minAbsoluteValue = getMinAbsoluteValue(numberA, numberB, numberC);

        // Вывод результата (наименьшего по модулю числа) на экран.
        System.out.println("Наименьшее по модулю число: " + minAbsoluteValue);


        scanner.close(); // Закрытие объекта Scanner.
    }

    public static int getMinAbsoluteValue(int a, int b, int c) {
        //Вычисление модуля числа с помощью тернарной операции и сохранение результата в absolute.
        int absoluteA = (a < 0) ? -a : a;
        int absoluteB = (b < 0) ? -b : b;
        int absoluteC = (c < 0) ? -c : c;

        // Выбор минимального модуля из трех чисел с помощью вложенной тернарной операции и возвращение его в качестве результата.

        if (absoluteA < absoluteB && absoluteA < absoluteC) {
            return absoluteA;
        } else if (absoluteB < absoluteA && absoluteB < absoluteC) {
            return absoluteB;
        } else {
            return absoluteC;

        }

    }
}
