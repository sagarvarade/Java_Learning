package com.kafkaLearning;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.SendResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class KafkaJavaMain {
    public static void main(String[] args) {
        produceMessage();
        getListOfTopics();
    }

    private static void getListOfTopics() {
        String bootstrapServers = "localhost:9092";

        // Configure AdminClient
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        // Create AdminClient
        try (AdminClient adminClient = AdminClient.create(config)) {
            // List topics
            ListTopicsResult listTopicsResult = adminClient.listTopics();
            Set<String> topics = listTopicsResult.names().get();

            // Print topic names
            System.out.println("Topics in the Kafka cluster:");
            for (String topic : topics) {
                System.out.println(topic);
            }
        } catch (ExecutionException | InterruptedException e) {
            System.err.println("Error listing topics: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private static void produceMessage() {
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
