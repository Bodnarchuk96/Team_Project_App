package test.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;
import main.java.com.example.repository.DataRepositoryImpl;
import main.java.com.example.service.ActionServiceImpl;
import main.java.com.example.service.EncryptionService;
import main.java.com.example.service.EncryptionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ActionServiceImplTest {

    private ActionServiceImpl actionService;
    private DataRepository dataRepository;
    private EncryptionService encryptionService;

    @Before
    public void setUp() {
        dataRepository = new DataRepositoryImpl();
        encryptionService = new EncryptionServiceImpl();

        actionService = new ActionServiceImpl(dataRepository, encryptionService, new Scanner(System.in));
    }

    @Test
    public void testRegister() {

        String input = "user1\npassword1@";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        actionService = new ActionServiceImpl(dataRepository, encryptionService, new Scanner(System.in));

        actionService.register();

        User user = dataRepository.findUserByUsername("user1");
        assertNotNull(user);
        assertEquals("user1", user.getUsername());
    }

    @Test
    public void testLogin() {

        dataRepository.saveUser(new User("user2", encryptionService.encryptPassword("password2@")));


        String input = "user2\npassword2@";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        actionService = new ActionServiceImpl(dataRepository, encryptionService, new Scanner(System.in));

        actionService.login();


    }

    @Test
    public void testRecoverPassword() {
        dataRepository.saveUser(new User("user3", encryptionService.encryptPassword("password3@")));


        String input = "user3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));


        actionService = new ActionServiceImpl(dataRepository, encryptionService, new Scanner(System.in));

        actionService.recoverPassword();


    }
}