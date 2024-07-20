package com.example.chatapp.Controller;

import com.example.chatapp.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.chatapp.Service.UsersService;

@RestController
@RequestMapping("/login")
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    @PostMapping("/addUser")
    public Users addUserDetails(@RequestBody Users user){
        return usersService.saveUserDetails(user);
    }

    @PostMapping("/getUser")
    public Users getUserDetails(@RequestBody Users user){
        return usersService.getUserDetails(user.getUsername(), user.getPassword());
    }

}
