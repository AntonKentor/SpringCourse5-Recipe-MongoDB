package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.converters.RecipeCommandToRecipe;
import com.recipe.springcourse5.recipe.converters.RecipeToRecipeCommand;
import com.recipe.springcourse5.recipe.exceptions.NotFoundException;
import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    private RecipeCommandToRecipe recipeCommandToRecipe;

    private RecipeServiceImpl recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById("33")).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById("1");

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById("33");
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipeCommandByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId("1");
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById("33")).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId("1");

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = recipeService.findCommandById("1");

        assertNotNull("Null recipe returned", commandById);
        verify(recipeRepository, times(1)).findById("33");
        verify(recipeRepository, never()).findAll();
    }

    @Test
    public void getRecipesTest() throws Exception {

        Recipe recipe = new Recipe();
        HashSet receipesData = new HashSet();
        receipesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(receipesData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById("33");
    }

    @Test
    public void testDeleteById() throws Exception {

        //given
        String idToDelete = "2";

        //when
        recipeService.deleteById(idToDelete);

        //no 'when', since method has void return type

        //then
        verify(recipeRepository, times(1)).deleteById("33");
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdRecipeNotFound(){
        Optional<Recipe> recipe = Optional.empty();
        when(recipeRepository.findById("33")).thenReturn(recipe);

        Recipe returnedRecipe = recipeService.findById("1");
    }

}