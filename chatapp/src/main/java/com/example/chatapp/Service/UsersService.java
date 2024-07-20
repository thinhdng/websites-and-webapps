package com.example.chatapp.Service;

import com.example.chatapp.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.chatapp.Repository.UsersRepository;
import java.util.Optional;

@Service
public class UsersService {
    
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUserDetails(Users user){
        return usersRepository.save(user);
    }

    public Users getUserDetails(String username, String password){
        Optional<Users> user = usersRepository.findByUsernameAndPassword(username, password);
        return user.orElse(null);
    }
}
