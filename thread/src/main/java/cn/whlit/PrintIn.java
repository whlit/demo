package cn.whlit;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintIn {
    private static final AtomicInteger a = new AtomicInteger();
    private final static int MAX = 100;
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    semaphoreA.acquire();
                    System.out.println("A");
                    semaphoreB.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    semaphoreB.acquire();
                    System.out.println("B");
                    semaphoreA.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();

    }
}
