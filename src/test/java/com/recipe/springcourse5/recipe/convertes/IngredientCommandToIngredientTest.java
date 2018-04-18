package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.IngredientCommand;
import com.recipe.springcourse5.recipe.models.Ingredient;
import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.recipe.springcourse5.recipe.TestConstants.DESCRIPTION;
import static com.recipe.springcourse5.recipe.TestConstants.LONG_ID_VALUE;
import static org.junit.Assert.*;

public class IngredientCommandToIngredientTest {

    private IngredientCommandToIngredient converter;
    private Recipe recipe = new Recipe();
    private UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
    BigDecimal amount = new BigDecimal(1);

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(LONG_ID_VALUE);
        ingredientCommand.setAmount(amount);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setRecipe(recipe);
        ingredientCommand.setUnitOfMeasure(unitOfMeasure);

        Ingredient convertedIngredient = converter.convert(ingredientCommand);
        assertNotNull(convertedIngredient);
        assertEquals(LONG_ID_VALUE, convertedIngredient.getId());
        assertEquals(amount, convertedIngredient.getAmount());
        assertEquals(DESCRIPTION, convertedIngredient.getDescription());
        assertEquals(recipe, convertedIngredient.getRecipe());
        assertEquals(unitOfMeasure, convertedIngredient.getUnitOfMeasure());

    }
}