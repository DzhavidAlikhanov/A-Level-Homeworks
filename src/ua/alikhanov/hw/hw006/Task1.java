package ua.alikhanov.hw.hw006;

public class Task1 {
    private String number;
    private String model;
    private double weight;

    // Конструктор принимающий три параметры для инициализации полей
    public Task1(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    // Констрструктор принимающий два параметра для инициализации полей
    public Task1(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0.0; // вес по умолчанию равен 0.0
    }

    // Конструктор без параметров
    public Task1() {
        this.number = "";
        this.model = "";
        this.weight = 0.0;
    }

    //
    public String getNumber() {
        return number;
    }

    //
    public void receiveCall(String callerName) {
        System.out.println("Звонит: " + callerName);
    }

    public static void main(String[] args) {

        //Создание трех экземпляров класса Phone
        Task1 phone1 = new Task1("+380991143780", "iPhone 5", 0.5);
        Task1 phone2 = new Task1("+380979459741", "OnePlus 6T", 0.7);
        Task1 phone3 = new Task1();

        //Вывод значения полей на консоль + вызов метода для принятия звонков
        System.out.println("Телефон 1: Номер - " + phone1.getNumber() + ", Модель - " + phone1.model + ", Вес - " + phone1.weight + " кг");
        phone1.receiveCall("Ибрагим");

        System.out.println("Телефон 2: Номер - " + phone2.getNumber() + ", Модель - " + phone2.model + ", Вес - " + phone2.weight + " кг");
        phone2.receiveCall("Мурад");

        System.out.println("Телефон 3: Номер - " + phone3.getNumber() + ", Модель - " + phone3.model + ", Вес - " + phone3.weight + " кг");
        phone3.receiveCall("Гасан");


    }
}








