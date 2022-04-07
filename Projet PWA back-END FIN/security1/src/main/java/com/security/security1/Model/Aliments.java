package com.security.security1.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Aliments")
@Getter
@Setter
public class Aliments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private float quantity;

    @Column(name = "total_cal")
    private int cal;

    public Aliments() {

    }

    public Aliments(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
