package com.rabbitmq.demo.repository;

import com.rabbitmq.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
