package com.example.client.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClientViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}