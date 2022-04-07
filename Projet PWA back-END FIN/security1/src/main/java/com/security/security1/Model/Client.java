package com.security.security1.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long nrClient;

    private String nom;
    private int dateNaissance;
    private String sexe;
    private float taille;
    private float poids;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Client() {

    }

    public Client(String n, int d, String s, float t, float p) {
        this.nom = n;
        this.dateNaissance = d;
        this.sexe = s;
        this.taille = t;
        this.poids = p;
    }
}
