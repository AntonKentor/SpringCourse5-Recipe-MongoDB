package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
