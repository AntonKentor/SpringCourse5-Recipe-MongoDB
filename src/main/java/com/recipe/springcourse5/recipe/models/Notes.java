package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @OneToOne
    private @Getter @Setter Recipe recipe;
    @Lob
    private @Getter @Setter String recipeNotes;

}
