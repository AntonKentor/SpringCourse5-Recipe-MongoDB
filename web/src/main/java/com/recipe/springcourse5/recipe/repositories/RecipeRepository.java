package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
