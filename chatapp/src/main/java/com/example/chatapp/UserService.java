package com.example.chatapp;

import java.util.List;

public interface UserService {
    List<String> getFriendsList(String username);
    // Other user-related methods
}