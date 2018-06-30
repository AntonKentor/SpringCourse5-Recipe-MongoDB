package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
