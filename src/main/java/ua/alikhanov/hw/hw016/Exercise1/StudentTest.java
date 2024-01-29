package ua.alikhanov.hw.hw016.Exercise1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentTest {
    public static void main(String[] args) {

        StudentInfoPrinter printer = new StudentInfoPrinter();

        Student student = printer.createStudent("Dzhavid", "Alikhanov", 27, 80);

        if (null != student) {
            printer.printStudentInfo(student);

            try {
                Method passExamMethod = student.getClass().getDeclaredMethod("passExamSuccessfully");
                passExamMethod.setAccessible(true);
                passExamMethod.invoke(student);

            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

            System.out.println("Новая оценка: " + student.getExamScore());
        } else {
            System.out.println("Ошибка при создании студента.");
        }
    }
}
