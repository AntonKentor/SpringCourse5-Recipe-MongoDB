package com.recipe.springcourse5.recipe.services;


import com.recipe.springcourse5.recipe.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, String ingredientId );
}
