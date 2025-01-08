package com.whlit.spring.starter.config;

import com.whlit.spring.starter.web.HealthController;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

/**
 * @auther WangHaiLong 2023/9/10 11:29
 */
//@AutoConfiguration
@ConditionalOnWebApplication
@ConditionalOnProperty(prefix = "demo.health", name = "enable", havingValue = "true")
public class MyAutoConfiguration {

    @Bean
    public HealthController healthController() {
        return new HealthController();
    }

}
