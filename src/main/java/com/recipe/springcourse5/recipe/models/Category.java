package com.recipe.springcourse5.recipe.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private @Getter @Setter Long id;

    @ManyToMany(mappedBy = "categories")
    private @Getter @Setter Set<Recipe> recipes;

    private @Getter @Setter String CategoryName;
}
