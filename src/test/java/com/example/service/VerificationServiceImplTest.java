package test.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;
import main.java.com.example.repository.DataRepositoryImpl;
import main.java.com.example.service.VerificationService;
import main.java.com.example.service.VerificationServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerificationServiceImplTest {

    private VerificationService verificationService;
    private DataRepository dataRepository;

    @Before
    public void setUp() {
        dataRepository = new DataRepositoryImpl();
        verificationService = new VerificationServiceImpl(dataRepository);
    }

    @Test
    public void testVerifyUser() {
        String username = "user1";
        String password = "password1";
        dataRepository.saveUser(new User(username, password));
        assertTrue(verificationService.verifyUser(username, password));
    }

    @Test
    public void testVerifyUserIncorrectPassword() {
        String username = "user1";
        String password = "password1";
        dataRepository.saveUser(new User(username, password));
        assertFalse(verificationService.verifyUser(username, "wrong password"));
    }

    @Test
    public void testVerifyUserNotFound() {
        assertFalse(verificationService.verifyUser("nonexistent", "password"));
    }
}