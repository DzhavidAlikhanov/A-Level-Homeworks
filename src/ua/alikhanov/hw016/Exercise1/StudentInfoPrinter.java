package ua.alikhanov.hw016.Exercise1;

import java.lang.reflect.Field;

public class StudentInfoPrinter {
    public void printStudentInfo(Student student) {
        Class<?> studentClass = student.getClass();
        Field[] fields = studentClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ShowInfo.class)) {
                ShowInfo annotation = field.getAnnotation(ShowInfo.class);
                if (annotation.show()) {
                    try {
                        field.setAccessible(true);
                        System.out.println(field.getName() + ": " + field.get(student));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
