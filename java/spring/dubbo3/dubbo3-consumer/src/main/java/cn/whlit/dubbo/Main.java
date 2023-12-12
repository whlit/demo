package cn.whlit.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @auther WangHaiLong 2023/8/14 23:12
 */
@SpringBootApplication
@EnableDubbo
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}