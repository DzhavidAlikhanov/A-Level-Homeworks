package ua.alikhanov.hw.hw009;

public class Receiver {
    private int variable1;
    private String variable2;

    public Receiver(int variable1, String variable2) {
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    public void method1() {
        System.out.println("Метод 1 выполнен.");
    }

    public void method2() {
        System.out.println("Метод 2 выполнен.");
    }

    public final void method3() {
        System.out.println("Метод 3 выполнен (final).");
    }
}
