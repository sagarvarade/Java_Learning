package com.kafkaLearning.Controller;

import com.kafkaLearning.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-rest")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> kafkaPublish(@PathVariable("message") String message){
        try{
            kafkaProducer.sendMessageToTopic(message);
            return ResponseEntity.ok("Message published successfully..");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
