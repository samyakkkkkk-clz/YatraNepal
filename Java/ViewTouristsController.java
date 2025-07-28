package com.touristattraction;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

import java.io.IOException;

public class ViewTouristsController {
    @FXML
    private Label headerLabel;
    @FXML
    private ListView<Tourist> touristListView;

    private ObservableList<Tourist> tourists = FXCollections.observableArrayList();
    private String language = "English";

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            headerLabel.setText("पर्यटकहरू हेर्नुहोस्");
        } else {
            headerLabel.setText("View Tourists");
        }
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) touristListView.getScene().getWindow();
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
    private void initialize() {
        tourists.add(new Tourist("John Doe"));
        tourists.add(new Tourist("Jane Smith"));
        tourists.add(new Tourist("Ravi Sharma"));
        tourists.add(new Tourist("Sita Gurung"));
        touristListView.setItems(tourists);
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
    private void goToManageAttractions() throws IOException {
        loadScene("/com/touristattraction/manage-attractions.fxml");
    }
}