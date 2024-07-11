package cn.whlit.service.config;

import cn.whlit.ItemService;
import cn.whlit.service.ItemServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangHaiLong 2024/7/10 22:21
 */
@Configuration
public class ServiceConfig {

    @Bean
    public ItemService itemService(){
        return new ItemServiceImpl();
    }

}
