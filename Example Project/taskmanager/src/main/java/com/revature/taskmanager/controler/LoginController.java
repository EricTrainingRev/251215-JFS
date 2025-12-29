package com.revature.taskmanager.controler;

import com.revature.taskmanager.dto.TokenTransport;
import com.revature.taskmanager.entity.Admin;
import com.revature.taskmanager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login/admin")
    public TokenTransport adminLogin(@RequestBody Admin credentials){
        return loginService.adminLogin(credentials);
    }

}
