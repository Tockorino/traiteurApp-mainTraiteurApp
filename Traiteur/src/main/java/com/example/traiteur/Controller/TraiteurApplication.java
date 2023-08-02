package com.example.traiteur.Controller;

import com.example.traiteur.Models.Articles;
import com.example.traiteur.Models.Categories;
import com.example.traiteur.Views.CommandeViewController;
import com.example.traiteur.Views.ProductViewController;
import com.example.traiteur.Views.TraiteurController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TraiteurApplication extends Application {
    public static List<String> categorieListe = new ArrayList<>();
    public static boolean existe = false;
    public static List<Categories> categories = new ArrayList<>();
    public static File file = new File("ListeArticles.txt");
    private static Stage principalStage;
    @Override
    public void start(Stage stage) throws IOException {
        if(file.exists()) {
            listeCategories();
        }
        else{
            file.createNewFile();
        }
        principalStage = stage;
        chargerTraiteurView();

        FXMLLoader fxmlLoader2 = new FXMLLoader(TraiteurController.class.getResource("Balance-view.fxml"));
        Scene scene2 = new Scene(fxmlLoader2.load());
        Stage stage2 = new Stage();
        stage2.setTitle("Balance");
        stage2.setScene(scene2);
        stage2.show();
    }

    private static void chargerTraiteurView() {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(TraiteurController.class.getResource("Traiteur-view.fxml"));
            Scene scene1 = null;
            scene1 = new Scene(fxmlLoader1.load());
            principalStage.setTitle("bonjour je suis traiteur");
            principalStage.setScene(scene1);
            principalStage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void refreshFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(TraiteurApplication.class.getResource("Traiteur-view.fxml"));
            Scene scene1 = null;
            scene1 = new Scene(loader.load());
            principalStage.setTitle("bonjour je suis traiteur");
            principalStage.setScene(scene1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static void listeCategories() {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                while(line != null) {
                    String categorieNom = line;
                    for (String cat : categorieListe) {
                        if (cat.equals(categorieNom)) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) {
                        categorieListe.add(categorieNom);
                        //ajouter la liste de catégories
                        Categories cat = new Categories();
                        cat.setNom(categorieNom);
                        categories.add(cat);
                    }
                    String article = br.readLine();
                    String prix = br.readLine();
                    String piece = br.readLine();
                    Articles articles = new Articles(article, Float.parseFloat(prix), Boolean.parseBoolean(piece));
                    for (Categories cat : categories) {
                        if (cat.getNom().equals(categorieNom)) {
                            cat.articles.add(articles);
                            break;
                        }
                    }
                    existe = false;
                    line = br.readLine();
                }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        /*
        // Création des catégories manuellement
        Categories fruit = new Categories();
        fruit.setNom("Fruit");
        Categories plat = new Categories();
        plat.setNom("Plat");
        Categories viandes = new Categories();
        viandes.setNom("Viandes");

        Articles pomme = new Articles("pomme", 1.5f, true);
        fruit.articles.add (pomme);
        Articles poire = new Articles("poire", 1.5f, true);
        fruit.articles.add(poire);

        Articles tartiflette = new Articles("tartiflette", 1.5f, false);
        plat.articles.add(tartiflette);

        Articles poulet = new Articles("poulet", 1.5f, false);
        viandes.articles.add(poulet);

        categories.add(fruit);
        categories.add(plat);
        categories.add(viandes);
        */
    }
    public static void ajouterArticle(String categorie, String article, float prix, boolean piece) {
        for (Categories cat : categories) {
            if (cat.getNom().equals(categorie)) {
                Articles articles = new Articles(article, prix, piece);
                cat.articles.add(articles);
                break;
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(categorie + "\n" + article + "\n" + prix + "\n" + piece + "\n");
        } catch(IOException e) {
            System.err.println("Erreur lors de l'écriture du fichier");
        }
    }

    public static void main(String[] args) {
    launch();
    }

}