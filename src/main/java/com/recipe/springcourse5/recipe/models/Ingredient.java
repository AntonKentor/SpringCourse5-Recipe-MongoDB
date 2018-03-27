package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Ingredient {

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    public Ingredient(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter String description;
    private @Getter @Setter BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private @Getter @Setter UnitOfMeasure unitOfMeasure;

    @ManyToOne
    private @Getter @Setter Recipe recipe;
}
