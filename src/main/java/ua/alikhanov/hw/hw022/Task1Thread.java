package ua.alikhanov.hw.hw022;

public class Task1Thread extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Hello, A-Level");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Обробка винятку переривання
                Thread.currentThread().interrupt();  // встановлюємо прапорець переривання знову
            }
        }
    }

    public static void main(String[] args) {
        Task1Thread thread = new Task1Thread();
        thread.start();
    }
}
