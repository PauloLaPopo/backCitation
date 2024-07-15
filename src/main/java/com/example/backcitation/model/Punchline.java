package com.example.backcitation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Punchline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String punchline;
    private String auteur;
    private String titre;

    public Punchline() {

    }

    public Punchline(String punchline, String auteur, String titre) {
        this.punchline = punchline;
        this.auteur = auteur;
        this.titre = titre;
    }

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public String getAuteur() { return auteur; }

    public void setAuteur(String auteur) {this.auteur = auteur; }

    public String getTitre() { return titre; }

    public void setTitre(String titre) { this.titre = titre; }
}
