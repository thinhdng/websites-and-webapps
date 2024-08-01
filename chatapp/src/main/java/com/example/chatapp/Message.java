package com.example.chatapp;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="chatAppMessages")
@Data
@NoArgsConstructor
public class Message {

    @Id
    private String id; // Unique identifier for the message
    private String sender; // Username of the sender
    private String recipient; // Username of the recipient
    private String content; // The actual message content
    private LocalDateTime timestamp; // Timestamp of when the message was sent
    private String conversationId;
}
