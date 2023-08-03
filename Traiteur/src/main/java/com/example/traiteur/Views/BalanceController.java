package com.example.traiteur.Views;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BalanceController {

    private ProductInteraction productInteraction;
    @FXML
    private TextField TextFieldBalance;

    public void setProductInteraction(ProductInteraction productInteraction) {
        this.productInteraction = productInteraction;
    }

    private String poidsString = "0"; // Initialiser la variable poidsString avec une valeur par défaut

    // Fonction pour récupérer le contenu du TextField TextFieldBalance
    public String getPoidsString() {
        return poidsString;
    }

    @FXML
    public void initialize() {

        // Ajouter un EventHandler pour détecter le changement de texte dans le TextFieldBalance
        TextFieldBalance.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                System.out.println("fref");
                // Mettre à jour la variable poidsString avec le nouveau texte du TextFieldBalance
                poidsString = TextFieldBalance.getText();
                productInteraction.nouvelleMasse(poidsString);
            }
        });
    }

    // Méthode publique pour obtenir la valeur de poidsString
    public String getPoidsStringValue() {
        if (TextFieldBalance != null) {
            return TextFieldBalance.getText();
        } else {
            return "227"; // ou une autre valeur par défaut
        }
    }


}