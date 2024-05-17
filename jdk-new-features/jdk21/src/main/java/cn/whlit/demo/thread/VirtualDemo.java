package cn.whlit.demo.thread;

import java.io.IOException;

/**
 * @author WangHaiLong 2024/5/11 19:45
 */
public class VirtualDemo {

    public static void main(String[] args) throws IOException {
        Thread thread = Thread.ofVirtual().name("Virtual Thread Demo").unstarted(() -> {
            System.out.println("Hello World");
            System.out.println(Thread.currentThread());
        });
        thread.start();

        System.in.read();

    }
}
