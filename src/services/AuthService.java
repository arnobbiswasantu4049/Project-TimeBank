package services;

import models.*;
import data.UserDataStore;
import java.util.List;
import java.util.ArrayList;

public class AuthService {

    private List<User> users;
    private UserDataStore userDataStore;

    public AuthService() {
        this.userDataStore = new UserDataStore();
        this.users = userDataStore.loadUsers();  // ইউজার লিস্ট ফাইল থেকে লোড করো

        if (users.isEmpty()) {
            // প্রথমে একটি Admin ইউজার দিয়ে দাও
            users.add(new Admin("admin01", "Super Admin", "admin@example.com", "adminpass"));
            userDataStore.saveUsers(users);  // ফাইলে সেভ করো যেন পরবর্তীতে পাওয়া যায়
        }
    }

    public boolean register(User user) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(user.getEmail())) {
                System.out.println("❌ Email already registered: " + user.getEmail());
                return false;
            }
        }
        users.add(user);
        userDataStore.saveUsers(users);  // নতুন ইউজার যুক্ত হলে ফাইল আপডেট করো
        System.out.println("✅ User registered successfully: " + user.getName());
        return true;
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                System.out.println("✅ Login successful: " + user.getName());
                return user;
            }
        }
        System.out.println("❌ Login failed. Invalid credentials.");
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
