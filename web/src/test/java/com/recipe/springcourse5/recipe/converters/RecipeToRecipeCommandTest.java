package com.recipe.springcourse5.recipe.converters;

import com.recipe.springcourse5.recipe.commands.RecipeCommand;
import com.recipe.springcourse5.recipe.enums.Difficulty;
import com.recipe.springcourse5.recipe.models.Category;
import com.recipe.springcourse5.recipe.models.Ingredient;
import com.recipe.springcourse5.recipe.models.Notes;
import com.recipe.springcourse5.recipe.models.Recipe;
import org.junit.Before;
import org.junit.Test;

import static com.recipe.springcourse5.recipe.TestConstants.*;
import static org.junit.Assert.*;

public class RecipeToRecipeCommandTest {

    private static final String RECIPE_ID = "1";
    private static final String CAT_ID_1 = "1";
    private static final Long CAT_ID2 = 2L;
    private static final Long INGRED_ID_1 = 3L;
    private static final Long INGRED_ID_2 = 4L;
    private static final Long NOTES_ID = 9L;
    private static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    private RecipeToRecipeCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new RecipeToRecipeCommand(
                new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Recipe()));
    }

    @Test
    public void convert() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Notes notes = new Notes();
        notes.setId("9");

        recipe.setNotes(notes);

        Category category = new Category();
        category.setId(CAT_ID_1);

        Category category2 = new Category();
        category2.setId("2");

        recipe.getCategories().add(category);
        recipe.getCategories().add(category2);

        Ingredient ingredient = new Ingredient();
        ingredient.setId("3");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId("4");

        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient2);

        //when
        RecipeCommand command = converter.convert(recipe);

        //then
        assertNotNull(command);
        assertEquals(RECIPE_ID, command.getId());
        assertEquals(COOK_TIME, command.getCookTime());
        assertEquals(PREP_TIME, command.getPrepTime());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(DIFFICULTY, command.getDifficulty());
        assertEquals(DIRECTIONS, command.getDirections());
        assertEquals(SERVINGS, command.getServings());
        assertEquals(SOURCE, command.getSource());
        assertEquals(URL, command.getUrl());
        assertEquals(NOTES_ID, command.getNotes().getId());
        assertEquals(2, command.getCategories().size());
        assertEquals(2, command.getIngredients().size());

    }

}