package com.kafkaLearning.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaNewTopicConfig {
    @Bean
    public NewTopic createNewTopic(){
        return  new NewTopic("topic-2",5, (short) 1);
    }

}
