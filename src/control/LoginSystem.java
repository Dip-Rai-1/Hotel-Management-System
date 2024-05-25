package control;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {
    private static LoginSystem instance;
    private Map<String, String> users;

    private LoginSystem() {
        users = new HashMap<>();
        users.put("admin", "password"); // Default user
    }

    // Singleton pattern: Ensure only one instance of LoginSystem
    public static LoginSystem getInstance() {
        if (instance == null) {
            instance = new LoginSystem();
        }
        return instance;
    }

    // Method to handle user login
    public boolean login() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (users.containsKey(username) && users.get(username).equals(password)) {
                System.out.println("Login successful!");
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
            scanner.close();
        }
    }
}
