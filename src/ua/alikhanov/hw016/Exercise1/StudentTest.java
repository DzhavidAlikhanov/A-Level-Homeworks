package ua.alikhanov.hw016.Exercise1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) {

        Student student = new Student();
        student.setFirstName("Dzhavid");
        student.setLastName("Alikhanov");
        student.setAge(Integer.parseInt("27"));
        student.setExamScore(80);

        Class<?> studentClass = student.getClass();
        try {
            Field firstNameField = studentClass.getDeclaredField("firstName");
            Field lastNameField = studentClass.getDeclaredField("lastName");

            firstNameField.getAnnotation(ShowInfo.class).show();
            lastNameField.getAnnotation(ShowInfo.class).show();

            StudentInfoPrinter printer = new StudentInfoPrinter();
            printer.printStudentInfo(student);

            Method passExamMethod = studentClass.getDeclaredMethod("passExamSuccessfully");
            passExamMethod.setAccessible(true);
            passExamMethod.invoke(student);

        } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("Новая оценка: " + student.getExamScore());
    }
}
