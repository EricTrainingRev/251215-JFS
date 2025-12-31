package com.revature.taskmanager.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    This WebConfig class is where we can provide custom configurations or our
    Spring application regarding the web capabilities of the app. To start with, we
    need to allow our Angular front end to make requests to our Spring application. To
    do this we need to edit our Cors configurations: unless our Angular app is given
    permissions to make requests to our app all requests from the front end to the
    back end will fail. Below in the overridden addCorsMappings method we tell our
    Spring application "All request from localhost:4200, our spring application, that
    are POST and GET requests, should be allowed".
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // addMapping sets the route pattern to be allowed
        registry.addMapping("/**")
                // allowedOriginPatterns sets the acceptable origins of the request
                .allowedOriginPatterns("http://localhost:4200")
                // allowedMethods sets the allowe request methods
                .allowedMethods("POST", "GET");
    }
}
