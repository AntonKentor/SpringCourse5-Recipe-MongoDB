package com.recipe.springcourse5.recipe.commands;

import com.recipe.springcourse5.recipe.enums.Difficulty;
import com.recipe.springcourse5.recipe.models.Category;
import com.recipe.springcourse5.recipe.models.Ingredient;
import com.recipe.springcourse5.recipe.models.Notes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Notes notes = new Notes();
    private Set<Category> categories = new HashSet<>();
    private Byte[] image;

}
