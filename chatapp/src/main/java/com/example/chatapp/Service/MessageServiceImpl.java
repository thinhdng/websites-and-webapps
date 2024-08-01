package com.example.chatapp.Service;

import com.example.chatapp.Message;
import com.example.chatapp.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public void sendMessageToUser(String username, Object message) {
        messagingTemplate.convertAndSendToUser(username, "/queue/messages", message);
    }

    @Override
    public List<Message> getMessageHistory(String sender, String recipient) {
        return messageRepository.findBySenderAndRecipient(sender, recipient);
    }
}