package com.rabbitmq.demo.service;

import com.rabbitmq.demo.model.Message;
import com.rabbitmq.demo.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageListener {

    private final AmqpTemplate amqpTemplate;
    private final MessageRepository messageRepository;

    public List<Message> getMessage() {
        return messageRepository.findAll();
    }

    @RabbitListener(queues = "${sample.rabbitmq.queue}")
    public void receiveMessages(String message) {
        messageRepository.save(new Message(message));
    }
}