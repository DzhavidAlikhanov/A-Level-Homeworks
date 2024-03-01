package ua.alikhanov.hw.hw023;

import java.util.concurrent.atomic.AtomicInteger;

class CounterWithAtomicVariable {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.incrementAndGet();
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter with Atomic variable: " + counter);
    }
}

