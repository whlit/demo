package cn.whlit;


/**
 * @author WangHaiLong 2023/5/9 17:52
 */
public class Main {

    private static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                synchronized (obj){
                    System.out.println("1 run");
                    Thread.sleep(1000);
                    System.out.println("1 end");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                synchronized (obj){
                    System.out.println("2 run");
                    Thread.sleep(10);
                    System.out.println("2 end");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("kkk");
            }
        });
        Thread thread3 = new Thread(() -> {

        });
        thread.start();
        thread.interrupt();
    }
}