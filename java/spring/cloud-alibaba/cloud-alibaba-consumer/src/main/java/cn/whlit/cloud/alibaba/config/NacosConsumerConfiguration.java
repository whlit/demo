package cn.whlit.cloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther WangHaiLong 2023/8/13 21:09
 */
@Configuration
public class NacosConsumerConfiguration {

    @LoadBalanced
    @Bean("balancedRestTemp")
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean("restTemp")
    public RestTemplate getRestTemplate2(){
        return new RestTemplate();
    }
}
