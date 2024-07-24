package com.kafkaLearning;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;

import java.util.Collections;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class ListKafkaTopicsExample {

    public static void main(String[] args) {
        // Kafka broker address
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
}
