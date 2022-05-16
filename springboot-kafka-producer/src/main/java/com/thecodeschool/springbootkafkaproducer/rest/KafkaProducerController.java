package com.thecodeschool.springbootkafkaproducer.rest;

import com.thecodeschool.springbootkafkaproducer.model.MessageBody;
import com.thecodeschool.springbootkafkaproducer.service.MessagePublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {
    @Autowired
    MessagePublishService messagePublishService;

    @PostMapping("/publish")
    public String produce(@RequestBody MessageBody messageBody) {
        System.out.println("message====> " + messageBody.getMessage());
        messagePublishService.publishMessage(messageBody);

        return "PUBLISHED";
    }
}
