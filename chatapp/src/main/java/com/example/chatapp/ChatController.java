package com.example.chatapp;

import com.example.chatapp.Service.MessageService;

import java.time.LocalDateTime;
import java.util.UUID;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate; 

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        chatMessage.setId(UUID.randomUUID().toString());
        chatMessage.setTimestamp(LocalDateTime.now());
        
        // Add the message to the database
        messageService.saveMessage(chatMessage);

        String conversationId = chatMessage.getConversationId();

        // Send the message to the recipient
        messagingTemplate.convertAndSend("/topic/conversation/"+conversationId,chatMessage);
    }

    @MessageMapping("/chat.addUser")
    public void addUser(@Payload String username, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in WebSocket session
        headerAccessor.getSessionAttributes().put("username", username);
    }

    @MessageMapping("/chat.getHistory")
    public void getMessageHistory(@Payload MessageHistoryRequest request) {
        List<Message> history = messageService.getMessageHistory(request.getSender(), request.getRecipient());

        String conversationId = request.getConversationId();
    
        // Send the message history to the specific conversation topic
        messagingTemplate.convertAndSend("/topic/conversation/" + conversationId, history);
    }
}