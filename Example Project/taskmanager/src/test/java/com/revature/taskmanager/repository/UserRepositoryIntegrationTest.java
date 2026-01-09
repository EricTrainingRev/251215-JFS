package com.revature.taskmanager.repository;

import com.revature.taskmanager.entity.User;
import com.revature.taskmanager.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*
    DataJpaTest tells Spring to only initialize the resources needed for the repository
    resources to function properly. It also tells Spring to wrap all tests within a
    transaction and to roll back the transaction after the test is completed, which
    provides some built-in test data resetting

    When using DataJpaTest Spring by default expects to work with a h2 in-memory
    database, which you must add to your dependencies. You can use a test.properties
    file and tell Spring to use that properties file for your tests to ensure that Spring
    has access to all the resources it needs in order for your tests to run correctly
 */
@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class UserRepositoryIntegrationTest {

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryIntegrationTest(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Test
    void findByUsernameAndPasswordPositiveTest() {
        User user = new User();
//        avoid setting the UUID in your test, will cause an error
//        user.setUserId(UUID.randomUUID());
        user.setUsername("testuser");
        user.setPassword("testpass");
        user.setRole(UserRole.ADMIN);
        userRepository.save(user);
        Optional<User> found = userRepository.findByUsernameAndPassword("testuser", "testpass");
        assertTrue(found.isPresent());
        assertEquals("testuser", found.get().getUsername());
        assertEquals("testpass", found.get().getPassword());
    }

    @Test
    void findByUsernameAndPasswordNegativeTest() {
        Optional<User> found = userRepository.findByUsernameAndPassword("wronguser", "wrongpass");
        assertFalse(found.isPresent());
    }
}
