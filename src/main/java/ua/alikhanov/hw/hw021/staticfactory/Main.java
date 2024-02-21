package ua.alikhanov.hw.hw021.staticfactory;

public class Main {
    public static void main(String[] args) {
        ObjectFactory.createCachedObject();
        ObjectFactory.createSimpleObject();
        ObjectFactory.createObjectUsingFactoryMethod("A");
        ObjectFactory.createObjectUsingFactoryMethod("B");
    }
}
