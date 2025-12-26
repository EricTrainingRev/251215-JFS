package com.revature.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    This class is used to facilitate sending JWT tokens back to the client
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenTransport {
    private String token;
}
