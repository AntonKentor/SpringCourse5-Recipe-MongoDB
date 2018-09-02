package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Ingredient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IngredientRepository extends ReactiveMongoRepository<Ingredient, String> {
}
