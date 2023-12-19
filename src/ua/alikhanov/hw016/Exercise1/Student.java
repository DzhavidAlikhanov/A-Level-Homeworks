package ua.alikhanov.hw016.Exercise1;

public class Student {
    @ShowInfo
    private String firstName;

    @ShowInfo
    private String lastName;

    @ShowInfo
    private int age;

    @ShowInfo
    private int examScore;

    public Student(String firstName, String lastName, int age, int examScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.examScore = examScore;
    }

    private void passExamSuccessfully() {
        this.examScore = 100;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }

    public int getExamScore() {
        return this.examScore;
    }
}
