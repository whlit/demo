package cn.whlit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.messaging.DefaultMessageListenerContainer;
import org.springframework.data.mongodb.core.messaging.MessageListenerContainer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WangHaiLong 2024/12/24 10:28
 */
@Configuration
public class MongoConfig {

    @Bean
    public MessageListenerContainer messageListenerContainer(MongoTemplate template) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer(template, executorService, error -> {
            System.out.println(error.getMessage());
        });
        container.start();
        return container;
    }

}
