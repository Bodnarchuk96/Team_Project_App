package main.java.com.example.service;

import java.util.HashMap;
import java.util.Map;


public class LoginAttemptServiceImpl implements LoginAttemptService {
    private static final int MAX_ATTEMPTS = 3;
    private final Map<String, Integer> attempts = new HashMap<>();

    @Override
    public boolean isBlocked(String username) {
        boolean blocked = attempts.getOrDefault(username, 0) >= MAX_ATTEMPTS;
        if (blocked) {
            System.out.println("[SECURITY] User " + username + " is blocked due to too many failed login attempts.");
        }
        return blocked;
    }

    @Override
    public void recordFailedAttempt(String username) {
        int currentAttempts = attempts.getOrDefault(username, 0);
        attempts.put(username, currentAttempts + 1);
        System.out.println("[SECURITY] Failed login attempt recorded for user " + username + ". Total attempts: " + attempts.get(username));
    }

    @Override
    public void resetAttempts(String username) {
        attempts.put(username, 0);
        System.out.println("[SECURITY] Login attempts reset for user " + username);
    }
}