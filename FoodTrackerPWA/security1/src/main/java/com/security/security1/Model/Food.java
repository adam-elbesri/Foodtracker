
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
@Table(name = "Food")
@Getter
@Setter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String product_name;
    private String generic_name;
    @Column(name = "salt_100g")

    private double salt;
    @Column(name = "sugars_100g")

    private double sugar;

    @Column(name = "proteins_100g")

    private double protein;

    @Column(name = "fat_100g")
    private double fat;
    private String image_url;
    private String quantity;

    @Column(name = "energy_kcal_100g")
    private double cal;

    public Food() {
    }

    public Food(String image_url, String product_name, String generic_name, double salt, double sugar, double protein,
            double fat, double cal, String quantity) {
        this.product_name = product_name;
        this.generic_name = generic_name;
        this.image_url = image_url;
        this.salt = salt;
        this.sugar = sugar;
        this.protein = protein;
        this.fat = fat;
        this.quantity = quantity;
        this.cal = cal;

    }
}
