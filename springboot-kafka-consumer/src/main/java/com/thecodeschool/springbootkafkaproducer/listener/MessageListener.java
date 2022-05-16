package com.thecodeschool.springbootkafkaproducer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "my-test-topic", groupId = "group_id")

    public void consume(String message) {
        System.out.println("message = " + message);
    }
}
