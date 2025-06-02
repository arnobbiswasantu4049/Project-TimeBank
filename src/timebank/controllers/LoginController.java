package timebank.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import services.AuthService;
import models.User;
public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private final AuthService authService = new AuthService();

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();
        User user = authService.login(email, password);

        if (user != null) {
            messageLabel.setText("✅ Login successful!");
        } else {
            messageLabel.setText("❌ Invalid email/password!");
        }
    }
}