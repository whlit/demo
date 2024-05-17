package cn.whlit.demo.process;

import java.io.IOException;

/**
 * @author WangHaiLong 2024/2/18 22:22
 */
public class ProcessMain {

    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe");
        Process process = processBuilder.start();

        System.out.println(process.pid());
        ProcessHandle.Info info = process.info();
        System.out.println(info);

    }
}
