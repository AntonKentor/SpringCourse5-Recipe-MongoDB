package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.models.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand findCommandById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);

}
