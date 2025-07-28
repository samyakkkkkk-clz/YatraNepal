package com.touristattraction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

import java.io.IOException;

public class ManageAttractionsController {
    @FXML
    private Label headerLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField attractionNameField;
    @FXML
    private ListView<Attraction> attractionListView;

    private ObservableList<Attraction> attractions = FXCollections.observableArrayList();
    private String language = "English";

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            headerLabel.setText("आकर्षणहरू व्यवस्थापन गर्नुहोस्");
            nameLabel.setText("आकर्षणको नाम:");
        } else {
            headerLabel.setText("Manage Attractions");
            nameLabel.setText("Attraction Name:");
        }
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) attractionNameField.getScene().getWindow();
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
    private void addAttraction() {
        Attraction attraction = new Attraction(attractionNameField.getText());
        attractions.add(attraction);
        attractionListView.setItems(attractions);
        attractionNameField.clear();
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
    private void goToAboutUs() throws IOException {
        loadScene("/com/touristattraction/about-us.fxml");
    }

    @FXML
    private void goToManageGuides() throws IOException {
        loadScene("/com/touristattraction/manage-guides.fxml");
    }

    @FXML
    private void goToViewTourists() throws IOException {
        loadScene("/com/touristattraction/view-tourists.fxml");
    }
}