package com.revature.taskmanager.service;

import com.revature.taskmanager.dto.TokenTransport;
import com.revature.taskmanager.entity.Admin;
import com.revature.taskmanager.entity.User;
import com.revature.taskmanager.exception.LoginFail;
import com.revature.taskmanager.util.JwtUtility;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private UserService userService;
    private JwtUtility jwtUtility;

    public LoginService(UserService userService, JwtUtility jwtUtility){
        this.userService = userService;
        this.jwtUtility = jwtUtility;
    }

    /*
        Here we use the admin service to return an optional that will contain
        the admin entity if the credentials provided are valid, otherwise the
        optional will be empty. If the entity is present we create a JWT and
        return it to the user, otherwise we throw our LoginFail exception and let
        our exception handler handle returning a response
     */
    public TokenTransport adminLogin(User credentials){
        Optional<User> userOptional = userService.findUserByCredentials(credentials.getUsername(), credentials.getPassword());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            String token = jwtUtility.generateAccessToken(user.getUserId(), user.getRole());
            return new TokenTransport(token);
        }
        throw new LoginFail("Invalid credentials");
    }

}
