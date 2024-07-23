package com.example.backcitation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "citations")
public class Citation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String texte;
    @Column(nullable = false)
    private String auteur;

    // Constructeurs
    public Citation() {
    }

    public Citation(String texte, String auteur) {

        this.texte = texte;
        this.auteur = auteur;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getAuteur() { return auteur; }

    public void setAuteur(String auteur) {this.auteur = auteur; }
}