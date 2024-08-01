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

    public Users getUsername(String username){
        Optional<Users> user = usersRepository.findByUsername(username);
        return user.orElse(null);
    }

    public boolean checkPassword(String password, Users user) {
        return user != null && user.getPassword().equals(password);
    }

    public boolean checkUsername(String username, Users user) {
        return user != null && user.getUsername().equals(username);
    }
}
