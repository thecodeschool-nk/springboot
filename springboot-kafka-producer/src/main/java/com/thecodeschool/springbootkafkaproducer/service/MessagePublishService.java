package com.thecodeschool.springbootkafkaproducer.service;

import com.thecodeschool.springbootkafkaproducer.model.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublishService {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public void publishMessage(MessageBody messageBody) {
        kafkaTemplate.send("my-test-topic", messageBody.getMessage());
    }
}
