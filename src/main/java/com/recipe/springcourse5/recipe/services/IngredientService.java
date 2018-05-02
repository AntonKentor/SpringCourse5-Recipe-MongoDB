package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.commands.IngredientCommand;
import com.recipe.springcourse5.recipe.models.Ingredient;

public interface IngredientService {

    Ingredient findById(Long ingredientId);

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand findCommandById(Long ingredientId);
}
