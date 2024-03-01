package ua.alikhanov.hw.hw022;

public class Task1Runnable implements Runnable {
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            System.out.println("Hello, A-Level");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();  // Восстанавливаем флаг прерывания
            }
        }
    }

    public void stopRunning() {
        isRunning = false;
    }

    public static void main(String[] args) {
        Task1Runnable task1Runnable = new Task1Runnable();
        Thread thread = new Thread(task1Runnable);
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        task1Runnable.stopRunning();
    }
}
