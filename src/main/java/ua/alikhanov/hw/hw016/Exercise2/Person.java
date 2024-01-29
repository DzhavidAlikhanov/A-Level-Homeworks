package ua.alikhanov.hw.hw016.Exercise2;

import java.lang.reflect.Field;

class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", adress='" + address + '\'' +
                '}';
    }
}

