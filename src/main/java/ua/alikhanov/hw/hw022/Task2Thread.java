package ua.alikhanov.hw.hw022;

public class Task2Thread extends Thread {
    private static final int MAX_ITERATIONS = 10;
    private static int counter = 0;

    public static int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task2Thread thread = new Task2Thread();
        thread.start();

        thread.join();

        System.out.println("Counter value: " + getCounter());
    }
}
