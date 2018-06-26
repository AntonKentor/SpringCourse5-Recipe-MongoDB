package com.recipe.springcourse5.recipe.controllers;

import com.recipe.springcourse5.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/recipe/list"})
    public String getIndexPage(Model model) {
        log.debug("in getIndexPage");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "/recipe/list.html";
    }
}
