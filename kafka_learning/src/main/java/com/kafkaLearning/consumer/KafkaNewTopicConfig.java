package com.kafkaLearning.consumer;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaNewTopicConfig {
    @Bean
    public NewTopic createNewTopic(){
        return  new NewTopic("topic-2",5, (short) 1);
    }

    @Bean
    public NewTopic createNewStudentTopic(){
        return  new NewTopic("student-topic",5, (short) 1);
    }
    @Bean
    public Map<String,Object> producerConfig(){
        Map<String,Object> props=new HashMap<String,Object>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092" );
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        return props;
    }
    @Bean
    public ProducerFactory<String,Object> producerFactory(){
        return  new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String,Object> kafkaTemplate(){
        return  new KafkaTemplate<>(producerFactory());
    }
}
