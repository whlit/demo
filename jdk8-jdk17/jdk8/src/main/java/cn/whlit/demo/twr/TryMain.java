package cn.whlit.demo.twr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author WangHaiLong 2024/2/19 9:14
 */
public class TryMain {

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Documents\\Test\\test.json"))) {
            String s = reader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
