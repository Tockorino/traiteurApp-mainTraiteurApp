package com.example.traiteur.Models;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    String nom;
    public List<Articles> articles = new ArrayList<Articles>();

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
