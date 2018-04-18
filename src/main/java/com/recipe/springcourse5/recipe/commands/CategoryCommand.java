package com.recipe.springcourse5.recipe.commands;

import com.recipe.springcourse5.recipe.models.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String description;
    private Set<Recipe> recipes = new HashSet<>();
}
