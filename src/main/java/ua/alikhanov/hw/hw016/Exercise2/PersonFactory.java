package ua.alikhanov.hw.hw016.Exercise2;

import java.lang.reflect.Field;

public class PersonFactory {

    public Person creataPerson(String name, int age, String address) {
        return new Person(name, age, address);
    }

    public void printFilds(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
