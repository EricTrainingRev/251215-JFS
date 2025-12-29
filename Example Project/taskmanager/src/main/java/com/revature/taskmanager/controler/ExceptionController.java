package com.revature.taskmanager.controler;

import com.revature.taskmanager.exception.LoginFail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
    To make the exception handlers in this controller global you use the
    RestControllerAdvice decorator. Make sure you only put handlers you actually
    want to be global in this class
 */
@RestControllerAdvice
public class ExceptionController {

    /*
        Any LoginFail exception that is unhandled in the application will be caught
        and dealt with here. This gives us a standard response for any type of
        login fail that happens moving forward. For any new types of users that can
        log in, this handler can be used for their login fails
     */
    @ExceptionHandler(LoginFail.class)
    public ResponseEntity<String> handleLoginFail(LoginFail exception){
        return ResponseEntity.status(401).body(exception.getMessage());
    }

}
