package com.example.chatapp.Repository;

import com.example.chatapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String>{
    Optional<Users> findByUsername(String username);
}
