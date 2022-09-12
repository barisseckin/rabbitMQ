package com.rabbitmq.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final AmqpTemplate amqpTemplate;

    public void sentRabbitMessage(String message) {
        amqpTemplate.convertAndSend("sample.rabbitmq.exchange", "sample.rabbitmq.routingkey", message);
    }
}
