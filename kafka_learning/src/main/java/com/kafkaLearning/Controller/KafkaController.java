package com.kafkaLearning.Controller;

import com.kafkaLearning.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka-rest")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish/{topic}/{key}/{message}/{count}")
    public ResponseEntity<String> kafkaPublish(@PathVariable("topic") String topic,@PathVariable("key") String key,@PathVariable("message") String message,@PathVariable("count") int count){
        try{
            for(int i=0;i<count;i++){
                kafkaProducer.sendMessageToTopic(topic,key,"MSG : "+message+" : "+i);
            }
            kafkaProducer.sendMessageToTopic(topic,key,message);
            return ResponseEntity.ok("Message published successfully..");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/get-list-of-topic")
    public ResponseEntity<List<String>> getListOfTopics(){
        return null;
    }

}
