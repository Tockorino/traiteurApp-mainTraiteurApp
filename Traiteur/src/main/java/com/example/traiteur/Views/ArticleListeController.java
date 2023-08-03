package com.example.traiteur.Views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;

public class ArticleListeController extends Node implements Serializable {
    @FXML
    private AnchorPane ArticleListeAnchor;
    @FXML
    private static Label PoidsLabel;
    @FXML
    private static Label NomLabel;
    @FXML
    private static Label PrixLabel;


    public void initialize() {
        PoidsLabel.setText("poidsProduit");
        NomLabel.setText("nomProduit");
        PrixLabel.setText("prixProduit");
    }
    public ArticleListeController(String nomProduit, String prixProduit, String poidsProduit) {
        PoidsLabel.setText(poidsProduit);
        NomLabel.setText(nomProduit);
        PrixLabel.setText(prixProduit);
    }
    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
