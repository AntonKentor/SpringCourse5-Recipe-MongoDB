package com.recipe.springcourse5.recipe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    private @Getter @Setter String description;
    private @Getter @Setter Integer prepTime;
    private @Getter @Setter Integer cookTime;
    private @Getter @Setter Integer servings;
    private @Getter @Setter String source;
    private @Getter @Setter String url;
    private @Getter @Setter String directions;

    @Lob
    private @Getter @Setter Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private @Getter @Setter Notes notes;

}
