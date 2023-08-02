package com.example.terminalpaiement.Views;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TerminalViewController {
    @FXML
    private Label LabelMessagePaiementTerminal;
    @FXML
    private Label LabelMontantTerminal;
    @FXML
    private Button BoutonOuiTerminal;
    @FXML
    private Button BoutonNonTerminal;
    @FXML
    private Label LabelAttenteTerminal;

    public double getPrix(){
        double prix = 0;

        if (prix > 0){
            LabelAttenteTerminal.setVisible(false);
            LabelMessagePaiementTerminal.setVisible(true);
            LabelMontantTerminal.setVisible(true);
            LabelMontantTerminal.setText(prix +"€");
            BoutonNonTerminal.setVisible(true);
            BoutonOuiTerminal.setVisible(true);

            BoutonOuiTerminal.setOnAction(event -> {
                afficherMessagePaiementReussi();
            });

            BoutonNonTerminal.setOnAction(event -> {
                afficherMessageErreurPaiement();
            });
        }
        return prix;
    }

    private void afficherMessagePaiementReussi() {
        LabelMessagePaiementTerminal.setText("Paiement effectué avec succès !");
    }

    private void afficherMessageErreurPaiement() {
        LabelMessagePaiementTerminal.setText("Erreur : Paiement non effectué !");
    }
}