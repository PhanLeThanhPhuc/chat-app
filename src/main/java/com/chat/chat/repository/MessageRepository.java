package com.chat.chat.repository;

import com.chat.chat.entity.Messages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Messages, String> {
}
