package com.example.terminalpaiement.Controller;

import com.example.terminalpaiement.Views.TerminalViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TerminalPaiementApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader4 = new FXMLLoader(TerminalViewController.class.getResource("Terminal-view.fxml"));
        Scene scene4 = new Scene(fxmlLoader4.load());
        Stage stage4 = new Stage();
        stage4.setTitle("Terminal");
        stage4.setScene(scene4);
        stage4.show();
    }

    public static void main(String[] args) {
        launch();
    }
}