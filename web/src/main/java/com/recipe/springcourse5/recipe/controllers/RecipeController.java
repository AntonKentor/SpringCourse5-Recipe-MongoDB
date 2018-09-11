package com.recipe.springcourse5.recipe.controllers;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        log.info("Showing recipe with id : " + id);
        model.addAttribute("recipe", recipeService.findById(id).block());
        return "recipe/show";
    }

    @GetMapping("/new")
    public String newRecipe(Model model) {
        log.info("add new recipe form");
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeForm";
    }

    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        log.info("updating recipe with id: " + id);
        model.addAttribute("recipe", recipeService.findCommandById(id).block());
        return "recipe/recipeForm";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdateRecipe(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult) {
        log.info("Saving/updating recipe "+command.getId());

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });

            return "recipe/recipeform";
        }

        RecipeCommand recipeCommand = recipeService.saveRecipeCommand(command).block();
        return "redirect:/recipe/" + recipeCommand.getId() + "/show";
    }

    @GetMapping("/{id}/delete")
    public String deleteById(@PathVariable String id, Model model) {
        log.info("delete recipe with id : " + id);
        recipeService.deleteById(id);
        return ("redirect:/");
    }

}