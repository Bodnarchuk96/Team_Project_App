package main.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;


public class VerificationServiceImpl implements VerificationService {
    private final DataRepository dataRepository;

    public VerificationServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public boolean verifyUser(String username, String password) {
        User user = dataRepository.findUserByUsername(username);
        boolean verified = user != null && user.getPassword().equals(password);
        if (verified) {
            System.out.println("[SECURITY] User " + username + " successfully verified.");
        } else {
            System.out.println("[ERROR] Verification failed for user " + username);
        }
        return verified;
    }
}