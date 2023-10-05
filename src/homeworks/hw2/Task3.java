package homeworks.hw2;

import java.util.Scanner; // Импорт класса Scanner для ввода с клавиатуры.


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

            if (isEven(number)) { // Вызов метода isEven для проверки, является ли число четным.
                System.out.println(number + " - четное число"); // Вывод сообщения о том, что число четное.
            } else {
                System.out.println(number + " - нечетное число"); // Вывод сообщения о том, что число нечетное.
            }
        }

        scanner.close(); // Закрытие объекта Scanner.
    }

    public static boolean isEven(int number) {

        return number % 2 == 0; //Проверка, является ли число четным, и возвращение результата.
    }
}







