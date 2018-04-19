package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.converters.RecipeCommandToRecipe;
import com.recipe.springcourse5.recipe.converters.RecipeToRecipeCommand;
import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        log.debug("in getRecipes");
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long id) {
        log.debug("In RecipeServiceImpl, method findById with parametervalue: " + id);
        Optional<Recipe> recipe = recipeRepository.findById(id);

        if (!recipe.isPresent()) {
            log.error("No recipe with id was found");
            throw new RuntimeException("No recipe with id: " + id + "was found");
        }
        return recipe.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveNewRecipe(RecipeCommand recipeCommand) {
        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);
        log.info("Saving new recipe with ID: " + recipe.getId());
        recipeRepository.save(recipe);
        return recipeToRecipeCommand.convert(recipe);
    }

}
