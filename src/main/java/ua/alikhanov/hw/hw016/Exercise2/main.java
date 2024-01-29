package ua.alikhanov.hw.hw016.Exercise2;

public class main {
    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();

        Person person = factory.creataPerson("Bob", 20, "Pochinki St");
        factory.printFilds(person);
    }
}
