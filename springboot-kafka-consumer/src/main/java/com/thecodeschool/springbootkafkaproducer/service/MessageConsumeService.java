package com.thecodeschool.springbootkafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumeService {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = "my-test-topic", groupId = "group_id")

    public void consume(String message) {
        System.out.println("message = " + message);
    }


    /*@KafkaListener
    public void consumeMessage() {
        var consumerRecord = kafkaTemplate.receive("my-test-topic", 0, 0, Duration.ofSeconds(30l));
        System.out.println("message====> "+ consumerRecord.value());
    }*/
}
