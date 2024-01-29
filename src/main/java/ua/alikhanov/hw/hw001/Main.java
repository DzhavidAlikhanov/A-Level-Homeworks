package ua.alikhanov.hw.hw001;

public class Main {
    public static void main(String[] args) {

        System.out.println("/////// Задание 2 ///////");

        String name = "Dzhavid";
        int age = 27;
        double weight = 64.5;

        System.out.println("Имя = " + name + ", Возраст = " + age + ", Вес = " + weight);
        System.out.println();

        System.out.println("/////// Задание 3 ///////");

        int a = 1;
        int b = 2;

        System.out.println("До обмена:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);


        int c = a;
        a = b;
        b = c;

        System.out.println("После обмена:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println();

        System.out.println("/////// Задание 4 ///////");

        performExchange();


    }

    public static void performExchange() {

        int a = 5;
        int b = 3;

        System.out.println("До обмена:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("После обмена:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}