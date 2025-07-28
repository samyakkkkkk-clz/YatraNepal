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

public class ManageGuidesController {
    @FXML
    private Label headerLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label nationalityLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private TextField fullNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField nationalityField;
    @FXML
    private TextField ageField;
    @FXML
    private ListView<Guide> guideListView;

    private ObservableList<Guide> guides = FXCollections.observableArrayList();
    private String language = "English";

    public void setLanguage(String lang) {
        this.language = lang;
        updateLanguage();
    }

    private void updateLanguage() {
        if (language.equals("Nepali")) {
            headerLabel.setText("गाइडहरू व्यवस्थापन गर्नुहोस्");
            nameLabel.setText("पूरा नाम:");
            emailLabel.setText("इमेल:");
            nationalityLabel.setText("राष्ट्रियता:");
            ageLabel.setText("उमेर:");
        } else {
            headerLabel.setText("Manage Guides");
            nameLabel.setText("Full Name:");
            emailLabel.setText("Email:");
            nationalityLabel.setText("Nationality:");
            ageLabel.setText("Age:");
        }
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) fullNameField.getScene().getWindow();
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
    private void addGuide() {
        try {
            Guide guide = new Guide(fullNameField.getText(), emailField.getText(), nationalityField.getText(), Integer.parseInt(ageField.getText()));
            guides.add(guide);
            guideListView.setItems(guides);
            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format");
        }
    }

    @FXML
    private void editGuide() {
        Guide selected = guideListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fullNameField.setText(selected.getFullName());
            emailField.setText(selected.getEmail());
            nationalityField.setText(selected.getNationality());
            ageField.setText(String.valueOf(selected.getAge()));
        }
    }

    @FXML
    private void updateGuide() {
        Guide selected = guideListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                selected.setFullName(fullNameField.getText());
                selected.setEmail(emailField.getText());
                selected.setNationality(nationalityField.getText());
                selected.setAge(Integer.parseInt(ageField.getText()));
                guideListView.refresh();
                clearFields();
            } catch (NumberFormatException e) {
                System.out.println("Invalid age format");
            }
        }
    }

    @FXML
    private void viewGuides() {
        guideListView.setItems(guides);
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
    private void goToManageAttractions() throws IOException {
        loadScene("/com/touristattraction/manage-attractions.fxml");
    }

    @FXML
    private void goToViewTourists() throws IOException {
        loadScene("/com/touristattraction/view-tourists.fxml");
    }

    private void clearFields() {
        fullNameField.clear();
        emailField.clear();
        nationalityField.clear();
        ageField.clear();
    }
}