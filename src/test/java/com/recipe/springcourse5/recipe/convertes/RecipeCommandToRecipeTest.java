package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.enums.Difficulty;
import com.recipe.springcourse5.recipe.models.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static com.recipe.springcourse5.recipe.TestConstants.*;
import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private RecipeCommandToRecipe converter;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
    private Notes notes = new Notes();

    @Before
    public void setUp() throws Exception {
        converter = new RecipeCommandToRecipe();
        ingredients.add(new Ingredient(DESCRIPTION, new BigDecimal(1), new UnitOfMeasure(), new Recipe()));
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new RecipeCommand()));
    }

    @Test
    public void convert() {

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(LONG_ID_VALUE);
        recipeCommand.setIngredients(ingredients);
        recipeCommand.setCategories(categories);
        recipeCommand.setCookTime(COOK_TIME);
        recipeCommand.setDescription(DESCRIPTION);
        recipeCommand.setDifficulty(Difficulty.MODERATE);
        recipeCommand.setNotes(notes);
        recipeCommand.setPrepTime(PREP_TIME);
        recipeCommand.setServings(SERVINGS);
        recipeCommand.setSource(SOURCE);
        recipeCommand.setUrl(URL);

        Recipe convertedRecipe = converter.convert(recipeCommand);

        assertNotNull(convertedRecipe);
        assertEquals(LONG_ID_VALUE, convertedRecipe.getId());
        assertEquals(ingredients, convertedRecipe.getIngredients());
        assertEquals(categories, convertedRecipe.getCategories());
        assertEquals(COOK_TIME, convertedRecipe.getCookTime());
        assertEquals(DESCRIPTION, convertedRecipe.getDescription());
        assertEquals(Difficulty.MODERATE, convertedRecipe.getDifficulty());
        assertEquals(notes, convertedRecipe.getNotes());
        assertEquals(PREP_TIME, convertedRecipe.getPrepTime());
        assertEquals(SERVINGS, convertedRecipe.getServings());
        assertEquals(SOURCE, convertedRecipe.getSource());
        assertEquals(URL, convertedRecipe.getUrl());

    }
}