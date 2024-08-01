package com.example.chatapp.Service;

import com.example.chatapp.Message;
import java.util.List;

public interface MessageService {
    void saveMessage(Message message);
    void sendMessageToUser(String username, Object message);
    List<Message> getMessageHistory(String sender, String recipient);
}
