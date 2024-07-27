package com.kafkaLearning.consumer;

import com.kafkaLearning.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerForTopics {

    Logger log= LoggerFactory.getLogger(KafkaListenerForTopics.class);

    @KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume(String message){
        log.info("Consumer:1 consume the message : {} ",message);
    }

    @KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume2(String message){
        log.info("Consumer:2 consume the message : {} ",message);
    }

    @KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume3(String message){
        log.info("Consumer:3 consume the message : {} ",message);
    }
    @KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume4(String message){
        log.info("Consumer:4 consume the message : {} ",message);
    }
    @KafkaListener(topics = "topic-2",groupId = "tp-group")
    public void consume5(String message){
        log.info("Consumer:5 consume the message : {} ",message);
    }


    @KafkaListener(topics = "student-topic",groupId = "std-group")
    public void consumeStudent(Student std){
        log.info("Consumer:5 consume the student : {} ",std.toString());
    }
}
