package com.recipe.springcourse5.recipe.controllers;

import com.recipe.springcourse5.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IngredientController {

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    private RecipeService recipeService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String editIngredient(@PathVariable String recipeId, Model model) {
        log.info("Getting ingredients from recipeId : " + recipeId);
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }
}
