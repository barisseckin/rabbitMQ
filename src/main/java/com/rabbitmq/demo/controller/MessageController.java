package com.rabbitmq.demo.controller;

import com.rabbitmq.demo.model.Message;
import com.rabbitmq.demo.service.HelloService;
import com.rabbitmq.demo.service.MessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rabbitmq")
@RequiredArgsConstructor
public class MessageController {

    private final HelloService helloService;
    private final MessageListener messageListener;

    @GetMapping
    public ResponseEntity<String> sendMessage(@RequestParam(value = "message") String message) {
        helloService.sentRabbitMessage(message);
        return ResponseEntity.ok("message send");
    }

    @GetMapping("/get-message")
    public ResponseEntity<List<Message>> getAll() {
        return ResponseEntity.ok(messageListener.getMessage());
    }

}
