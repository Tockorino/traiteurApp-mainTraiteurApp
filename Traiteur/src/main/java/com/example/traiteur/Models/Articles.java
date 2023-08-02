package com.example.traiteur.Models;

public class Articles {
    String nom;
    float prix;
    boolean pc;
    String image;

    public Articles(String nom, float prix, boolean type) {
        this.nom = nom;
        this.prix = prix;
        this.pc = type;
    }

    public Articles(String nom, float prix, boolean type, String image) {
        this.nom = nom;
        this.prix = prix;
        this.pc = type;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public boolean getType() {
        return pc;
    }

    public Object getPrix() {
        return prix;
    }

}
