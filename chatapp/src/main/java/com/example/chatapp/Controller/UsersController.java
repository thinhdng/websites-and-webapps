package com.example.chatapp.Controller;

import com.example.chatapp.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.chatapp.Service.UsersService;

@Controller
@RequestMapping("/")
public class UsersController {
    
    @Autowired
    private UsersService usersService;
    
    @GetMapping("/login") //thymeleaf will find these templates in the templates folder and show them
    public String loginPage() {
        return "login";
    }

    @GetMapping("/conversations")
    public String conversationsPage(){
        return "conversations";
    }

    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; 
    }

    @PostMapping("login/addUser")
    public String addUserDetails(@RequestBody Users user){
        Users userDetails = usersService.getUsername(user.getUsername());
    
        if(userDetails != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already existed");
        } else {
            usersService.saveUserDetails(user);
            return "redirect:/conversations";
        }
    }

    @PostMapping("login/auth")
    public String getUserDetails(@RequestBody Users user){
        Users userDetails = usersService.getUsername(user.getUsername());

        if(userDetails == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username doesn't exist.");
        }//compare the password from the post call (userdetails) with the password from the request body(user)
        else if(!usersService.checkPassword(userDetails.getPassword(), user)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Incorrect password");
        }else
            return "redirect:/conversations";
    }

}
