package ua.alikhanov.hw.hw009;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Лев", 10, "мясо");
        Animal animal2 = new Animal("Слон", 14, "траву");
        Animal animal3 = new Animal("Тигр", 12, "мясо");

        Animal maxSleepingAnimal = animal1;
        if (animal2.getHoursOfSleeping() > maxSleepingAnimal.getHoursOfSleeping()) {
            maxSleepingAnimal = animal2;
        }
        if (animal3.getHoursOfSleeping() > maxSleepingAnimal.getHoursOfSleeping()) {
            maxSleepingAnimal = animal3;
        }

        System.out.println(maxSleepingAnimal.getName() + " спит больше всех.");
        System.out.println(maxSleepingAnimal.getName() + " ест " + maxSleepingAnimal.getFood() + ".");

        Receiver receiver = new Receiver(42, "строка");

        receiver.method1();
        receiver.method2();
        receiver.method3();
    }
}
