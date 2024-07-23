package com.example.chatapp.Controller;

import com.example.chatapp.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping(value="/auth")
    public void getUserDetails(@RequestBody Users user){
        Users userDetails = usersService.getUsername(user.getUsername());

        if(userDetails == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username doesn't exist.");
        }

        //compare the password from the post call (userdetails) with the password from the request body(user)
        if(!usersService.checkPassword(userDetails.getPassword(), user)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }

    }

}
