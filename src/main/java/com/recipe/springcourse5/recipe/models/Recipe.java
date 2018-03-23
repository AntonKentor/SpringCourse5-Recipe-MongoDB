package com.recipe.springcourse5.recipe.models;

import com.recipe.springcourse5.recipe.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private @Getter @Setter Set<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(name = "recipe_category",
               joinColumns = @JoinColumn(name = "recipe_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
     private @Getter @Setter Set<Category> categories;

    @Lob
    private @Getter @Setter Byte[] image;

    @Enumerated(value = EnumType.STRING)
    private @Getter @Setter Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private @Getter @Setter Notes notes;

}
