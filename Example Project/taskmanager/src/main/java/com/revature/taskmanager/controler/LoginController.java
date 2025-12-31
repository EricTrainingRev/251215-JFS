package com.revature.taskmanager.controler;

import com.revature.taskmanager.dto.TokenTransport;
import com.revature.taskmanager.entity.User;
import com.revature.taskmanager.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping("/login/admin")
    public TokenTransport adminLogin(@RequestBody User credentials){
        return loginService.adminLogin(credentials);
    }

}
