package com.kafkaLearning;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class KafkaJavaMain {
    public static void main(String[] args) {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);


        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("mytopic","key", "message");

        send.whenComplete((res,ex)-> {
            if (ex == null) {
                System.out.println("Sent message : " + res.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to Sent message : " + ex.getMessage());
            }
        });
    }
}
