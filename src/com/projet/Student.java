package com.projet;

public class Student {
    private String nom;
    private String postnom;
    private String genre;
    private String promotion;

    public Student(String nom, String postnom, String genre, String promotion) {
        this.nom = nom;
        this.postnom = postnom;
        this.genre = genre;
        this.promotion = promotion;
    }

    public Student() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}
