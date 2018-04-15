package com.recipe.springcourse5.recipe.controllers;

import com.recipe.springcourse5.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){
        log.info("In method showById with id-value: "+id);
        model.addAttribute("recipe", recipeService.findById(new Long(id)));
        return "recipe/show";
    }
}