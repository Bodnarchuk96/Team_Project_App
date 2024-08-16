package test.java.com.example.service;

import main.java.com.example.service.LoginAttemptService;
import main.java.com.example.service.LoginAttemptServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAttemptServiceTest {

    private LoginAttemptService loginAttemptService;

    @Before
    public void setUp() {
        loginAttemptService = new LoginAttemptServiceImpl();
    }

    @Test
    public void testIsBlocked() {
        String username = "user1";
        assertFalse(loginAttemptService.isBlocked(username));
    }

    @Test
    public void testRecordFailedAttempt() {
        String username = "user1";
        loginAttemptService.recordFailedAttempt(username);
        loginAttemptService.recordFailedAttempt(username);
        loginAttemptService.recordFailedAttempt(username);
        assertTrue(loginAttemptService.isBlocked(username));
    }

    @Test
    public void testResetAttempts() {
        String username = "user1";
        loginAttemptService.recordFailedAttempt(username);
        loginAttemptService.resetAttempts(username);
        assertFalse(loginAttemptService.isBlocked(username));
    }
}