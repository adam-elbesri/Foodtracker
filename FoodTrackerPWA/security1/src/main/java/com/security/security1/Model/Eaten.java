package com.security.security1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name = "Eaten")

public class Eaten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double portion;
    private String date;

    @ManyToOne
    private Food food;

    @ManyToOne
    private User user;

    public Eaten() {

    }

    public Eaten(long id, double portion, String date) {
        this.portion = portion;
        this.id = id;
        this.date = date;
    }

    public Eaten(long id, double portion, String date, User user, Food food) {

        this.portion = portion;
        this.user = user;
        this.food = food;
        this.id = id;
        this.date = date;
    }

    public Eaten(double portion, String date, User user, Food food) {

        this.portion = portion;
        this.user = user;
        this.food = food;

        this.date = date;
    }

}
