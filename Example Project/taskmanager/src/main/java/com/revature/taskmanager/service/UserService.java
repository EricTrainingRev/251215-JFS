package com.revature.taskmanager.service;

import com.revature.taskmanager.entity.User;
import com.revature.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Spring will use this constructor automatically for dependency injection
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByCredentials(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
