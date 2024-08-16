package test.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;
import main.java.com.example.repository.DataRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataRepositoryImplTest {

    private DataRepository dataRepository;

    @Before
    public void setUp() {
        dataRepository = new DataRepositoryImpl();
    }

    @Test
    public void testSaveAndFindUser() {
        User user = new User("user1", "password1");
        dataRepository.saveUser(user);
        User retrievedUser = dataRepository.findUserByUsername("user1");
        assertEquals(user.getUsername(), retrievedUser.getUsername());
    }
}