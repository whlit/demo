package cn.whlit.spring.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @auther WangHaiLong 2023/9/10 10:30
 */
@ConfigurationProperties(prefix = "demo.health")
public class HealthProps implements Serializable {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
