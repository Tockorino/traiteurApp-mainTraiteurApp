package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BalanceController {

    @FXML
    private static TextField TextFieldBalance;

    public static String getPoidsString() {
        String poids;
        if(TextFieldBalance == null){
            poids = "300";
        }
        else {
            poids = TextFieldBalance.getText();
        }
        return poids;
    }

}