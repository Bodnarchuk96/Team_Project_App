package test.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;
import main.java.com.example.repository.DataRepositoryImpl;
import main.java.com.example.service.PasswordRecoveryService;
import main.java.com.example.service.PasswordRecoveryServiceImpl;
import org.junit.Before;
import org.junit.Test;



public class PasswordRecoveryServiceImplTest {

    private PasswordRecoveryService passwordRecoveryService;
    private DataRepository dataRepository;

    @Before
    public void setUp() {
        dataRepository = new DataRepositoryImpl();
        passwordRecoveryService = new PasswordRecoveryServiceImpl(dataRepository);
    }

    @Test
    public void testSendRecoveryEmail() {
        String username = "user1";
        dataRepository.saveUser(new User(username, "password1"));
        passwordRecoveryService.sendRecoveryEmail(username);

    }

    @Test
    public void testSendRecoveryEmailUserNotFound() {
        passwordRecoveryService.sendRecoveryEmail("nonexistent");

    }
}