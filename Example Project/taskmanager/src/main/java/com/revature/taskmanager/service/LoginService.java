package com.revature.taskmanager.service;

import com.revature.taskmanager.dto.TokenTransport;
import com.revature.taskmanager.entity.Admin;
import com.revature.taskmanager.exception.LoginFail;
import com.revature.taskmanager.repository.AdminRepository;
import com.revature.taskmanager.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtility jwtUtility;

    /*
        Here we use the admin service to return an optional that will contain
        the admin entity if the credentials provided are valid, otherwise the
        optional will be empty. If the entity is present we create a JWT and
        return it to the user, otherwise we throw our LoginFail exception and let
        our exception handler handle returning a response
     */
    public TokenTransport adminLogin(Admin credentials){
        Optional<Admin> adminOptional = adminService.findAdminByCredentials(credentials.getUsername(), credentials.getPassword());
        if(adminOptional.isPresent()){
            Admin admin = adminOptional.get();
            String token = jwtUtility.generateAccessToken(admin.getAdminID(), admin.getUsername());
            return new TokenTransport(token);
        }
        throw new LoginFail("Invalid credentials");
    }

}
