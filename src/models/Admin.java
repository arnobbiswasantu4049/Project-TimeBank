package models;

import java.util.List;

public class Admin extends User {

    public Admin(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    // Show list of all users with details
    public void viewAllUsers(List<User> users) {
        System.out.println("\n=== All Registered Users ===");
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        for (User user : users) {
            System.out.println("ID: " + user.getUserId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }
        System.out.println("============================\n");
    }

    // Dummy ban user method (can be extended)
    public void banUser(User user) {
        // এখানে তুমি চাইলে user object এ banned ফ্ল্যাগ সেট করতে পারো, এখন ডামি মেসেজ
        System.out.println("🚫 User '" + user.getName() + "' has been banned. (Dummy implementation)");
    }

    @Override
    public void viewDashboard() {
        System.out.println("\n🛡️ Admin Dashboard for: " + getName());
        System.out.println("🕒 Time Credits: " + getTimeCredits());
        System.out.println("🛠️ Services managed: " + getServices());
        System.out.println();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", timeCredits=" + timeCredits +
                ", services=" + services +
                '}';
    }
}
