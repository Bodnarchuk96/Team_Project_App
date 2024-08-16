package main.java.com.example.repository;

import main.java.com.example.entity.User;


public interface DataRepository {
    void saveUser(User user);
    User findUserByUsername(String username);
}