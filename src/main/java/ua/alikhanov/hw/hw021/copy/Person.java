package ua.alikhanov.hw.hw021.copy;

public class Person {
    private final String name;
    private final Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Person deepCopy() {
        return new Person(this.name, new Address("Default Street", "Default City"));
    }

    public Address getAddress() {
        return address;
    }
}
