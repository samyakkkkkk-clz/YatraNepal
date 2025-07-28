package com.touristattraction;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class AboutUsController {
    @FXML
    private Label aboutLabel;
    @FXML
    private Label descriptionLabel;

    private String language = "English";

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            aboutLabel.setText("हाम्रो बारेमा");
            descriptionLabel.setText("यात्रा नेपाल तपाईंको नेपालको सौन्दर्य अन्वेषण गर्न विश्वसनीय साझेदार हो। हाम्रो प्रविधिले पर्यटकहरूलाई गाइडहरू र आकर्षणहरूसँग सजिलै जोड्छ।");
        } else {
            aboutLabel.setText("About Us");
            descriptionLabel.setText("Yatra Nepal is your trusted partner for exploring the beauty of Nepal. Our technology connects tourists with guides and attractions seamlessly.");
        }
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) aboutLabel.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        scene.getStylesheets().add(getClass().getResource("/com/touristattraction/styles.css").toExternalForm());
        stage.setScene(scene);
        if (fxmlLoader.getController() instanceof HomeController) {
            ((HomeController) fxmlLoader.getController()).setLanguage(language);
        } else if (fxmlLoader.getController() instanceof AboutUsController) {
            ((AboutUsController) fxmlLoader.getController()).setLanguage(language);
        }
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
    private void goToSignUp() throws IOException {
        loadScene("/com/touristattraction/signup.fxml");
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