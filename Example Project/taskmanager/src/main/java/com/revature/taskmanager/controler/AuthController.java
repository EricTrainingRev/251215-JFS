package com.revature.taskmanager.controler;

import com.revature.taskmanager.service.AuthService;
import com.revature.taskmanager.util.JwtUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping("/auth/admin")
    public ResponseEntity<Void> validateAdminToken(@RequestHeader String Authorization){
        boolean isValid = authService.validateAdminToken(Authorization);
        if(isValid){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
