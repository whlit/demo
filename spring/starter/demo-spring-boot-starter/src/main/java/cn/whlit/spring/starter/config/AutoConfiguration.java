package cn.whlit.spring.starter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @auther WangHaiLong 2023/9/10 11:29
 */
@Configuration
@ComponentScan("cn.whlit.spring.starter.web.HealthController")
public class AutoConfiguration {
}
