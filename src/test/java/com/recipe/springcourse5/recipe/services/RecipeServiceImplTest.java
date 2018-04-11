package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @Mock
    private RecipeRepository recipeRepository;
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);

        //Mock methodcall
        when(recipeService.getRecipes()).thenReturn(recipeSet);
        Set<Recipe> recipes = recipeService.getRecipes();

        //Verify that method has been called.
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}