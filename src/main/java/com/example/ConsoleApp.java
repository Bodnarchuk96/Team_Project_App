package main.java.com.example;

import main.java.com.example.controller.ActionController;


public class ConsoleApp {
    public static void main(String[] args) {
        System.out.println("[SYSTEM] Starting the User Registration and Authentication System...");
        ActionController actionController = new ActionController();
        actionController.controlLoop();
        System.out.println("[SYSTEM] Console application terminated.");
    }
}