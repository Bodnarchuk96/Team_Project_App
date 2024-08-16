package main.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;


public class PasswordRecoveryServiceImpl implements PasswordRecoveryService {
    private final DataRepository dataRepository;

    public PasswordRecoveryServiceImpl(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void sendRecoveryEmail(String username) {
        User user = dataRepository.findUserByUsername(username);
        if (user != null) {
            System.out.println("[EMAIL] Sending password recovery email to " + user.getUsername());
        } else {
            System.out.println("[ERROR] User not found.");
        }
    }
}