package com.example.backcitation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "punchlines")
public class Punchline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(unique = true, nullable = false)
    private String punchline;
    @Column(nullable = false)
    private String auteur;
    @Column(nullable = false)
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
