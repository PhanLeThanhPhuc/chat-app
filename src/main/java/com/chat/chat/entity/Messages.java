package com.chat.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Messages {

    @Id
    private String id;
    private String conversationId; // Conversation ID
    private String senderId; // User ID
    private String content;
    private Date timestamp;

}
