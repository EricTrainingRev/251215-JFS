package com.revature.docker_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Greeter {
    
    @GetMapping("/greet/{name}")
    public ResponseEntity<String> getGreeting(@PathVariable("name") String name){
        String response = "Hello " + name;
        return ResponseEntity.ok().body(response);
    }

}
