package ua.alikhanov.hw016.Exercise1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) {

        StudentInfoPrinter printer = new StudentInfoPrinter();

        Student student = printer.createStudent("Dzhavid", "Alikhanov", 27, 80);

        printer.printStudentInfo(student);

        try {
            Method passExamMethod = student.getClass().getDeclaredMethod("passExamSuccessfully");
            passExamMethod.setAccessible(true);
            passExamMethod.invoke(student);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println("Новая оценка: " + student.getExamScore());
    }
}
