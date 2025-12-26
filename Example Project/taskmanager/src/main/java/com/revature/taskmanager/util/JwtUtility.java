package com.revature.taskmanager.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtility {

    // This key will be sued for signing the jwt
    private final String SECRET_KEY = "your-key-should-be-at-least-32-bytes";

    // the JJWT Jwts resource uses the builder design pattern to facilitate creating your JWT
    public String generateAccessToken(UUID userId, String username){
        return Jwts.builder()
                // The subject is the value we want to check to validate who the user is
                .subject(userId.toString())
                // If you need to access secondary information use the claim function
                .claim("username", username)
                // we want to set when the jwt is created so we can set an expiration for the token
                .issuedAt(new Date())
                // the time works in miliseconds, so you will have to do a bit of math to get the time you want
                .expiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)) // 15 minutes
                // we then use our secret key to sign the jwt in order to encrypt it
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), Jwts.SIG.HS256)
                .compact();
    }

    // the JWT parser is used to extract information from our JWT, it also uses the builder design pattern
    public String extractId(String token){
        return Jwts.parser()
                // set the secret key we need to use to decrypt the token
                .verifyWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                // actually create the parser
                .build()
                // decrypt the jwt
                .parseSignedClaims(token)
                // get the data from the jwt
                .getPayload()
                // get the subject from the jwt data
                .getSubject();
    }

}
