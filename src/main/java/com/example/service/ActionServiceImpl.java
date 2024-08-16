package main.java.com.example.service;

import main.java.com.example.entity.User;
import main.java.com.example.repository.DataRepository;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ActionServiceImpl implements ActionService {
    private final DataRepository dataRepository;
    private final EncryptionService encryptionService;
    private final Scanner scanner;

    public ActionServiceImpl(DataRepository dataRepository, EncryptionService encryptionService, Scanner scanner) {
        this.dataRepository = dataRepository;
        this.encryptionService = encryptionService;
        this.scanner = scanner;
    }

    @Override
    public void register() {
        System.out.print("[INPUT] Enter username: ");
        String username = scanner.nextLine();

        System.out.print("[INPUT] Enter password: ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            System.out.println("[ERROR] Password must be at least 8 characters long, contain at least one digit and one special character.");
            return;
        }

        String encryptedPassword = encryptionService.encryptPassword(password);

        User newUser = new User(username, encryptedPassword);
        dataRepository.saveUser(newUser);
        System.out.println("[SUCCESS] Registration successful for " + username);
    }

    @Override
    public void login() {
        System.out.print("[INPUT] Enter username: ");
        String username = scanner.nextLine();
        User user = dataRepository.findUserByUsername(username);

        if (user != null) {
            System.out.print("[INPUT] Enter password: ");
            String password = scanner.nextLine();
            String encryptedPassword = encryptionService.encryptPassword(password);
            if (encryptedPassword.equals(user.getPassword())) {
                System.out.println("[SUCCESS] Login successful.");
            } else {
                System.out.println("[ERROR] Incorrect password.");
            }
        } else {
            System.out.println("[ERROR] User not found.");
        }
    }

    @Override
    public void recoverPassword() {
        System.out.print("[INPUT] Enter username for password recovery: ");
        String username = scanner.nextLine();
        User user = dataRepository.findUserByUsername(username);

        if (user != null) {
            System.out.println("[INFO] Password recovery instructions have been sent to your registered email.");
            System.out.println("[EMAIL] Password recovery email sent to " + username);
        } else {
            System.out.println("[ERROR] User not found.");
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                Pattern.compile("[0-9]").matcher(password).find() &&
                Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }
}