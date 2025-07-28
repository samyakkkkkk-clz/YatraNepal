package com.touristattraction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Label taglineLabel;

    private String language = "English"; // Default language

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            welcomeLabel.setText("यात्रा नेपालमा स्वागत छ");
            taglineLabel.setText("तपाईंको यात्रा, हाम्रो प्रविधि");
        } else {
            welcomeLabel.setText("Welcome To Yatra Nepal");
            taglineLabel.setText("Your Journey, Our Technology");
        }
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) welcomeLabel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("/com/touristattraction/styles.css").toExternalForm());
        stage.setScene(scene);
    }

    @FXML
    private void goToLogin() throws IOException {
        loadScene("/com/touristattraction/login.fxml");
    }

    @FXML
    private void goToSignUp() throws IOException {
        loadScene("/com/touristattraction/signup.fxml");
    }
}