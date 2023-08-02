package com.example.traiteur.Controller;

import com.example.traiteur.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BalanceApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader2 = new FXMLLoader(TraiteurController.class.getResource("Balance-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Balance");
        stage2.setScene(scene2);
        stage2.show();

    }
}
