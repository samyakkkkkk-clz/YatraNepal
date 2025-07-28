package com.touristattraction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label loginLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private Label languageLabel;
    @FXML
    private TextField emailMobileField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ChoiceBox<String> languageChoice;
    @FXML
    private Hyperlink forgetPasswordLink;

    private String language = "English";

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            loginLabel.setText("लगइन गर्नुहोस्");
            emailLabel.setText("इमेल वा मोबाइल नम्बर:");
            passwordLabel.setText("पासवर्ड:");
            languageLabel.setText("भाषा छान्नुहोस्:");
            forgetPasswordLink.setText("पासवर्ड बिर्सनुभयो?");
        } else {
            loginLabel.setText("Login In");
            emailLabel.setText("Email or Mobile Number:");
            passwordLabel.setText("Password:");
            languageLabel.setText("Choose a Language:");
            forgetPasswordLink.setText("Forget your Password?");
        }
    }

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
    private void login() throws IOException {
        String emailMobile = emailMobileField.getText();
        String password = passwordField.getText();
        String language = languageChoice.getValue();
        System.out.println("Login: " + emailMobile + ", Password: " + password + ", Language: " + language);
        loadScene("/com/touristattraction/manage-guides.fxml");
    }

    @FXML
    private void forgetPassword() {
        System.out.println("Forget Password clicked");
    }

    @FXML
    private void goToHome() throws IOException {
        loadScene("/com/touristattraction/home.fxml");
    }

    @FXML
    private void goToSignUp() throws IOException {
        loadScene("/com/touristattraction/signup.fxml");
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