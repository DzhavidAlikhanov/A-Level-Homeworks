package ua.alikhanov.hw.hw021.copy;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Main Street", "Cityville");
        Person originalPerson = new Person("John", address);

        Person clonedPerson = originalPerson.deepCopy();

        System.out.println(originalPerson.getAddress() != clonedPerson.getAddress());
    }
}
