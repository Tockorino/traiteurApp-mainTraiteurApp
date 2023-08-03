package com.example.traiteur.Views;

import com.example.traiteur.Controller.TraiteurApplication;

import com.example.traiteur.Models.Articles;
import com.example.traiteur.Models.Categories;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.traiteur.Views.BalanceController.*;

public class ProductViewController implements ProductInteraction{

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button ButtonAjouter;

    @FXML
    private Label LabelNomProduit;

    @FXML
    private Label LabelPoidProduit;

    @FXML
    private Label LabelPrixProduit;

    @FXML
    private VBox vboxListeArticle;
    @FXML
    void openNouvelArticle(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader5 = new FXMLLoader(TraiteurController.class.getResource("Nouvel-Article-view.fxml"));
        Scene scene5 = new Scene(fxmlLoader5.load());
        Stage stage5 = new Stage();
        stage5.setTitle("Nouveaux Articles");
        stage5.setScene(scene5);
        stage5.show();
    }

    public void initialize() {
      //  BalanceController balanceController = new BalanceController(this);
        String poidsBal = "";//balanceController.getPoidsString();
      //  System.out.println(poidsBal);


        for(Categories cat : TraiteurApplication.categories){
            TitledPane titledPane = new TitledPane();
            titledPane.setText(cat.getNom());
            FlowPane flowPane = new FlowPane();
            vboxListeArticle.getChildren().add(titledPane);
            titledPane.setContent(flowPane);
            for(Articles article : cat.articles){
                Button buttonArticle = new Button(article.getNom());
                flowPane.getChildren().add(buttonArticle);
                buttonArticle.setUserData(article);
                //ajouter action
                buttonArticle.setOnAction(event -> {
                    LabelNomProduit.setText(((Articles)buttonArticle.getUserData()).getNom());
                    LabelPoidProduit.setText(poidsBal);
                });
                this.informationArticle(buttonArticle);
            }
            Button buttonNewArticle = new Button("Ajouter un article");
            buttonNewArticle.setOnAction(event -> {
                try {
                    openNouvelArticle(event);
                } catch (IOException e) {
                    System.err.println("problem");
                }
            });
            flowPane.getChildren().add(buttonNewArticle);
        }
    }

    private void informationArticle(Button article) {

        LabelNomProduit.setText(((Articles)article.getUserData()).getNom());
        //LabelPoidProduit.setText(poidsBal);
        float prixCalculer = 0;
        float prix = (float) ((Articles) article.getUserData()).getPrix();
        //float poids = Float.parseFloat(poidsBal);
       // if(((Articles) article.getUserData()).getType()){
         //   prixCalculer = poids * prix;
        //    LabelPrixProduit.setText(prixCalculer+ "€");
       // }
        //else{
         //   prixCalculer = (prix/1000)*poids;
        //    LabelPrixProduit.setText(prixCalculer + "€/kg");
        }
   // }


    public void rechargerVue(){
        vboxListeArticle.getChildren().clear();
        initialize();
    }

    public void ajouterNouveauBoutonArticle(String nomArticle, double prix){
        Button nouveauArticle = new Button (nomArticle + " " + prix);
    }

    public void ajouterAuPanier(){
        try {
            CommandeViewController.ajouterProduit(LabelNomProduit.getText(), LabelPoidProduit.getText(), LabelPrixProduit.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void nouvelleMasse(String masse) {
        System.out.println(masse);
        LabelPoidProduit.setText(masse);
        //float poids = Float.parseFloat(poidsBal);
        // if(((Articles) article.getUserData()).getType()){
        //   prixCalculer = poids * prix;
        //    LabelPrixProduit.setText(prixCalculer+ "€");
        // }
        //else{
        //   prixCalculer = (prix/1000)*poids;
        //    LabelPrixProduit.setText(prixCalculer + "€/kg");

    // }
    }
}
