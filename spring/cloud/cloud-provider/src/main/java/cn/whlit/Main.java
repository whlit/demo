package cn.whlit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @auther WangHaiLong 2023/8/12 22:02
 */
@SpringBootApplication
@EnableEurekaClient
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}