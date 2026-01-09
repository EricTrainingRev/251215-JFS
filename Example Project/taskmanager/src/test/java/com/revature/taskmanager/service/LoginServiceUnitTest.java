package com.revature.taskmanager.service;

import com.revature.taskmanager.dto.TokenTransport;
import com.revature.taskmanager.entity.User;
import com.revature.taskmanager.enums.UserRole;
import com.revature.taskmanager.exception.LoginFail;
import com.revature.taskmanager.util.JwtUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
    When mocking resources for Unit testing we want to let Mockito handle initializing our test resources. We can use
    the Mock annotation to indicate what dependencies should be mocked and InjectMock to tell Mockito which resource
    needs the mock objects for dependency injection

    Once your mocks are set up you want to make sure that for every test you are stubbing any method calls that the
    dependencies make: this will ensure that if any tests fail we know the error in the code is located in our tested
    method, not in any of the dependencies
 */
@ExtendWith(MockitoExtension.class)
public class LoginServiceUnitTest {

    @Mock
    private UserService userService;
    @Mock
    private JwtUtility jwtUtility;
    @InjectMocks
    private LoginService loginService;

    @Test
    void adminLoginPositiveTest() {
        User mockUser = new User();
        UUID userId = UUID.randomUUID();
        mockUser.setUserId(userId);
        mockUser.setUsername("admin");
        mockUser.setPassword("admin");
        mockUser.setRole(UserRole.ADMIN);

        when(userService.findUserByCredentials("admin", "admin")).thenReturn(Optional.of(mockUser));
        when(jwtUtility.generateAccessToken(userId, UserRole.ADMIN)).thenReturn("mocked-jwt-token");

        TokenTransport result = loginService.adminLogin(mockUser);
        assertNotNull(result);
        assertEquals("mocked-jwt-token", result.getToken());
    }

    @Test
    void adminLoginNegativeTest() {
        User invalidUser = new User();
        invalidUser.setUsername("wrong");
        invalidUser.setPassword("wrong");
        invalidUser.setRole(UserRole.ADMIN);

        when(userService.findUserByCredentials("wrong", "wrong")).thenReturn(Optional.empty());

        assertThrows(LoginFail.class, () -> loginService.adminLogin(invalidUser));
    }
}
