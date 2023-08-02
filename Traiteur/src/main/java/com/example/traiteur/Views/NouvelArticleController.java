package com.example.traiteur.Views;

import com.example.traiteur.Controller.TraiteurApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class NouvelArticleController {

    @FXML
    private Button ButtonAjouterArticle;

    @FXML
    private Button ButtonAnnulerArticle;

    @FXML
    private RadioButton RadioButtonKilo;

    @FXML
    private RadioButton RadioButtonPiece;

    @FXML
    private ChoiceBox<String> ChoixCatégories;

    @FXML
    private TextField TextNom;

    @FXML
    private TextField TextPrix;

    private ToggleGroup prixToggleGroup;

    public void initialize() {
        prixToggleGroup = new ToggleGroup();
        RadioButtonKilo.setToggleGroup(prixToggleGroup);
        RadioButtonPiece.setToggleGroup(prixToggleGroup);

        ChoixCatégories.getItems().addAll(TraiteurApplication.categorieListe);

        ButtonAjouterArticle.setOnAction(event -> {
            try {
                ajouterArticle();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        ButtonAnnulerArticle.setOnAction(event -> {
            closeStage();
        });
    }
// Ajouter un article dans le fichier texte
    public void ajouterArticle() throws IOException {
        String catégorie = ChoixCatégories.getValue();
        String nomArticle = TextNom.getText();
        float prix = Float.parseFloat(TextPrix.getText());
        boolean typePrix;
        if (RadioButtonKilo.isSelected()){
            typePrix = false;
        } else {
            typePrix = true;
        }
        TraiteurApplication.ajouterArticle(catégorie, nomArticle, prix, typePrix);
        closeStage();
        //rafraichir la liste des articles
        //TraiteurApplication.refreshFXML();
    }
    public void closeStage(){
        Stage stage = (Stage) TextNom.getScene().getWindow();
        stage.close();
    }
}