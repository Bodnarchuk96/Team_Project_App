package main.java.com.example.controller;

import main.java.com.example.repository.DataRepository;
import main.java.com.example.repository.DataRepositoryImpl;
import main.java.com.example.service.ActionService;
import main.java.com.example.service.ActionServiceImpl;
import main.java.com.example.service.EncryptionService;
import main.java.com.example.service.EncryptionServiceImpl;

import java.util.Scanner;


public class ActionController {
    private final Scanner scanner;
    private final ActionService actionService;


    public ActionController() {
        this.scanner = new Scanner(System.in);
        DataRepository dataRepository = new DataRepositoryImpl();
        EncryptionService encryptionService = new EncryptionServiceImpl();
        this.actionService = new ActionServiceImpl(dataRepository, encryptionService, scanner);
    }

    public void controlLoop() {
        Action action;
        int input;
        do {
            System.out.println("\n[MENU] Please choose an action:");
            System.out.println("1. Register a new account");
            System.out.println("2. Log in to an existing account");
            System.out.println("3. Recover your password");
            System.out.println("4. Exit");
            System.out.print("[INPUT] Enter your choice (1-4): ");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("[ACTION] You chose to register a new account.");
                    actionService.register();
                    break;
                case 2:
                    System.out.println("[ACTION] You chose to log in to an existing account.");
                    actionService.login();
                    break;
                case 3:
                    System.out.println("[ACTION] You chose to recover your password.");
                    actionService.recoverPassword();
                    break;
                case 4:
                    System.out.println("[ACTION] Exiting the system...");
                    break;
                default:
                    System.out.println("[ERROR] Invalid input. Please enter a number between 1 and 4.");
                    continue;
            }
        } while (input != 4);
        scanner.close();
        System.out.println("[SYSTEM] Goodbye!");
    }
}