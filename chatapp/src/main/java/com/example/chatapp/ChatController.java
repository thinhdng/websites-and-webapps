package com.example.chatapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login"; // Ensure this points to the correct login.html template
    }

    @GetMapping("/chat")
    public String getChatPage() {
        return "chat"; // Ensure this points to the correct chat.html template
    }
}