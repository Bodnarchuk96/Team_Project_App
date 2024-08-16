package main.java.com.example.service;


public interface LoginAttemptService {
    boolean isBlocked(String username);
    void recordFailedAttempt(String username);
    void resetAttempts(String username);
}