package cn.whlit.maven.thread;

/**
 * @author WangHaiLong 2024/7/10 15:14
 */
public class ThreadLocalDemo {

    static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            THREAD_LOCAL.set("thread one");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(THREAD_LOCAL.get());
        });
        Thread thread2 = new Thread(() -> {
            THREAD_LOCAL.set("thread two");
            System.out.println(THREAD_LOCAL.get());
        });
        thread1.start();
        thread2.start();
    }
}
