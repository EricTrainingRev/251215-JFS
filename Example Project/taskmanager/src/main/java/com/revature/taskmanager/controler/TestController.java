package com.revature.taskmanager.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/health")
    public ResponseEntity<Void> healthCheck(){
        return ResponseEntity.status(200).body(null);
    }

}
