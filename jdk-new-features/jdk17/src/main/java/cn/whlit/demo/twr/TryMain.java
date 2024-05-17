package cn.whlit.demo.twr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author WangHaiLong 2024/2/19 9:11
 */
public class TryMain {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\Documents\\Test\\test.json");
        BufferedReader reader = new BufferedReader(fileReader);
        // jdk9 之前是必须要放到try后面的括号里定义 Closeable 变量
        try(fileReader;reader) {
            String s = reader.readLine();
            System.out.println(s);
        }
        // 在try中会自动执行close方法
        reader.readLine();
    }
}
