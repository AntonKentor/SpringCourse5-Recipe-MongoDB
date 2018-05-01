package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
