package ua.alikhanov.hw.hw021.staticfactory;

public class ObjectFactory {
    public static void createCachedObject() {
        System.out.println("Creating cached object with caching logic");
        new CachedObject();
    }

    public static void createSimpleObject() {
        System.out.println("Creating simple object with creation logic");
        new SimpleObject();
    }

    public static void createObjectUsingFactoryMethod(String type) {
        if (type.equals("A")) {
            System.out.println("Creating ObjectA using Factory Method");
            new ObjectA();
        } else if (type.equals("B")) {
            System.out.println("Creating ObjectB using Factory Method");
            new ObjectB();
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }

    private static class CachedObject {
        private CachedObject() {
            System.out.println("CachedObject instance created");
        }
    }

    private static class SimpleObject {
        private SimpleObject() {
            System.out.println("SimpleObject instance created");
        }
    }

    private static class ObjectA {
        private ObjectA() {
            System.out.println("ObjectA instance created");
        }
    }

    private static class ObjectB {
        private ObjectB() {
            System.out.println("ObjectB instance created");
        }
    }
}
