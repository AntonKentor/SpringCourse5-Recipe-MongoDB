package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.NotesCommand;
import com.recipe.springcourse5.recipe.models.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Synchronized
    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        if (source == null) {
            return null;
        }
        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        notes.setRecipe(source.getRecipe());
        return notes;
    }
}
