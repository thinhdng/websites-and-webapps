package com.example.chatapp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageHistoryRequest {
    private String sender;
    private String recipient;
    private String conversationId;
}