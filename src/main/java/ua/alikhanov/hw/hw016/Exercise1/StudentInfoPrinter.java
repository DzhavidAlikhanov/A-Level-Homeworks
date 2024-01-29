package ua.alikhanov.hw.hw016.Exercise1;

import java.lang.reflect.Constructor;
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

    public Student createStudent(String firstName, String lastName, int age, int examScore) {
        try {
            Class<Student> studentClass = Student.class;
            Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class, String.class, int.class, int.class);
            constructor.setAccessible(true);
            Student student = constructor.newInstance(firstName, lastName, age, examScore);

            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
