package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.CategoryCommand;
import com.recipe.springcourse5.recipe.models.Category;
import com.recipe.springcourse5.recipe.models.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static com.recipe.springcourse5.recipe.TestConstants.DESCRIPTION;
import static com.recipe.springcourse5.recipe.TestConstants.LONG_ID_VALUE;
import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    private CategoryCommandToCategory converter;
    private Set<Recipe> recipes = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
        recipes.add(new Recipe());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {

        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);
        categoryCommand.setRecipes(recipes);

        Category convertedCategory = converter.convert(categoryCommand);
        assertNotNull(convertedCategory);
        assertEquals(LONG_ID_VALUE, convertedCategory.getId());
        assertEquals(DESCRIPTION, convertedCategory.getDescription());
        assertEquals(recipes, convertedCategory.getRecipes());
    }
}