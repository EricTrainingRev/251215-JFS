package com.revature.taskmanager.service;

import com.revature.taskmanager.enums.UserRole;
import com.revature.taskmanager.util.JwtUtility;
import io.jsonwebtoken.JwtException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JwtUtility jwtUtility;

    public AuthService(JwtUtility jwtUtility){
        this.jwtUtility = jwtUtility;
    }

    public boolean validateAdminToken(String headerData){
        if(headerData == null){
            return false;
        }
        try{
            String token = headerData.split(" ")[1];
            System.out.println(token);
            UserRole role = this.jwtUtility.extractUserRole(token);
            return role.equals(UserRole.ADMIN);
        } catch (JwtException e) {
            e.printStackTrace();
            return false;
        }

    }
}
