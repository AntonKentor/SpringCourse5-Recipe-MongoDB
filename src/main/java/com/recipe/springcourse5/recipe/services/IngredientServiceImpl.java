package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.commands.IngredientCommand;
import com.recipe.springcourse5.recipe.converters.IngredientToIngredientCommand;
import com.recipe.springcourse5.recipe.models.Ingredient;
import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.IngredientRepository;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    public IngredientServiceImpl(IngredientToIngredientCommand ingredientToIngredientCommand, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    private IngredientToIngredientCommand ingredientToIngredientCommand;
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;


    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);

        if (!recipe.isPresent()) {
            //TODO add exceptionhandling
            log.error("Could not find recipe with id : " + recipeId);
        }

        Optional<IngredientCommand> ingredientCommand = recipe.get().getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommand.isPresent()) {
            //TODO add exceptionhandling
            log.error("Could not find ingredient with id : " + ingredientId);
        }
        return ingredientCommand.get();
    }

    @Override
    @Transactional
    public IngredientCommand findCommandById(Long ingredientId) {
        return ingredientToIngredientCommand.convert(findById(ingredientId));
    }

    @Override
    public Ingredient findById(Long ingredientId) {
        log.info("Ingredient. find by id: " + ingredientId);
        Optional<Ingredient> ingredient = ingredientRepository.findById(ingredientId);

        if (!ingredient.isPresent()) {
            log.error("No ingredient with id was found");
            throw new RuntimeException("No recipe with id: " + ingredient + "was found");
        }
        return ingredient.get();

    }
}
