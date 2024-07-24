package com.kafkaLearning.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessageToTopic(String topic,String key,String message){
        CompletableFuture<SendResult<String, Object>> send = template.send(topic,key, message);
        send.whenComplete((res,ex)->{
            if(ex==null){
                System.out.println("Sent message : "+res.getRecordMetadata().offset());
            }else{
                System.out.println("Unable to Sent message : "+ex.getMessage());
            }
        });

    }

}
