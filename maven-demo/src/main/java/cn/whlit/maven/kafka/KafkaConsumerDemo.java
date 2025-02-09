package cn.whlit.maven.kafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author WangHaiLong 2025/1/22 19:58
 */
public class KafkaConsumerDemo {

    public static void main(String[] args) {
        HashMap<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.24.160.1:9092");
        configs.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer-demo");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 5000);
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(configs)) {
            consumer.subscribe(List.of("test"));

            while (true) {
                consumer.poll(Duration.ofSeconds(1)).forEach(record -> {
                    System.out.println(record.key() + ":" + record.value());
                });
            }
        }

    }
}
