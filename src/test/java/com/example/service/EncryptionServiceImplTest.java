package test.java.com.example.service;

import main.java.com.example.service.EncryptionService;
import main.java.com.example.service.EncryptionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionServiceImplTest {

    private EncryptionService encryptionService;

    @Before
    public void setUp() {
        encryptionService = new EncryptionServiceImpl();
    }

    @Test
    public void testEncryptPassword() {
        String password = "password";

        String expectedHash = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
        String actualHash = encryptionService.encryptPassword(password);

        assertNotEquals(password, actualHash);
        assertEquals(expectedHash, actualHash);
    }
}