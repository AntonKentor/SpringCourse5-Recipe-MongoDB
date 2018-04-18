package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.NotesCommand;
import com.recipe.springcourse5.recipe.models.Notes;
import com.recipe.springcourse5.recipe.models.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.recipe.springcourse5.recipe.TestConstants.LONG_ID_VALUE;
import static com.recipe.springcourse5.recipe.TestConstants.RECIPE_NOTES;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

public class NotesCommandToNotesTest {

    private NotesCommandToNotes converter;
    private Recipe recipe = new Recipe();

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        Assert.assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {

        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(LONG_ID_VALUE);
        notesCommand.setRecipe(recipe);
        notesCommand.setRecipeNotes(RECIPE_NOTES);

        Notes convertedNotes = converter.convert(notesCommand);
        assertNotNull(convertedNotes);
        assertEquals(LONG_ID_VALUE, convertedNotes.getId());
        assertEquals(recipe, convertedNotes.getRecipe());
        assertEquals(RECIPE_NOTES, convertedNotes.getRecipeNotes());
    }
}