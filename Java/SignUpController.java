package com.touristattraction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class SignUpController {
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailMobileField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> languageChoice;

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) emailMobileField.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("/com/touristattraction/styles.css").toExternalForm());
        stage.setScene(scene);
        if (fxmlLoader.getController() instanceof HomeController) {
            ((HomeController) fxmlLoader.getController()).setLanguage(languageChoice.getValue());
        } else if (fxmlLoader.getController() instanceof AboutUsController) {
            ((AboutUsController) fxmlLoader.getController()).setLanguage(languageChoice.getValue());
        }
    }

    @FXML
    private void signUp() throws IOException {
        String fullName = fullNameField.getText();
        String emailMobile = emailMobileField.getText();
        String password = passwordField.getText();
        String language = languageChoice.getValue();
        System.out.println("Sign Up: " + fullName + ", " + emailMobile + ", Password: " + password + ", Language: " + language);
        loadScene("/com/touristattraction/manage-guides.fxml");
    }

    @FXML
    private void goToHome() throws IOException {
        loadScene("/com/touristattraction/home.fxml");
    }

    @FXML
    private void goToLogin() throws IOException {
        loadScene("/com/touristattraction/login.fxml");
    }

    @FXML
    private void goToAboutUs() throws IOException {
        loadScene("/com/touristattraction/about-us.fxml");
    }

    @FXML
    private void goToManageGuides() throws IOException {
        loadScene("/com/touristattraction/manage-guides.fxml");
    }

    @FXML
    private void goToManageAttractions() throws IOException {
        loadScene("/com/touristattraction/manage-attractions.fxml");
    }

    @FXML
    private void goToViewTourists() throws IOException {
        loadScene("/com/touristattraction/view-tourists.fxml");
    }
}