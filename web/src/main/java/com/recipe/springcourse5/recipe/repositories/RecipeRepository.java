package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecipeRepository extends ReactiveMongoRepository<Recipe, String> {
}
