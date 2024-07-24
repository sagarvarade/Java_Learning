package com.kafkaLearning.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KafkaListener {

    Logger log= LoggerFactory.getLogger(KafkaListener.class);

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume(String message){
        log.info("Consumer:1 consume the message : {} ",message);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume2(String message){
        log.info("Consumer:2 consume the message : {} ",message);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume3(String message){
        log.info("Consumer:3 consume the message : {} ",message);
    }
    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume4(String message){
        log.info("Consumer:4 consume the message : {} ",message);
    }
    @org.springframework.kafka.annotation.KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume5(String message){
        log.info("Consumer:5 consume the message : {} ",message);
    }
}
