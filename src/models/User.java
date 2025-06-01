package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User implements Serializable {

    protected String userId;
    protected String name;
    protected String email;
    protected String password;
    protected double timeCredits;
    protected List<String> services;

    public User(String userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.timeCredits = 0.0;
        this.services = new ArrayList<>();
    }

    // Getter methods
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getTimeCredits() {
        return timeCredits;
    }

    public List<String> getServices() {
        return services;
    }

    // Setter methods (optional)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTimeCredits(double credits) {
        this.timeCredits = credits;
    }

    // Add service to user's list
    public void addService(String service) {
        services.add(service);
    }

    // Dashboard method — দেখাবে ইউজারের ড্যাশবোর্ড
    public void viewDashboard() {
        System.out.println("\n📊 User Dashboard for: " + name);
        System.out.println("🕒 Time Credits: " + timeCredits);
        System.out.println("🛠️ Services: " + services + "\n");
    }

    // toString for debugging
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", timeCredits=" + timeCredits +
                ", services=" + services +
                '}';
    }

    // equals and hashCode based on email (unique)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return email.equalsIgnoreCase(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email.toLowerCase());
    }
}
