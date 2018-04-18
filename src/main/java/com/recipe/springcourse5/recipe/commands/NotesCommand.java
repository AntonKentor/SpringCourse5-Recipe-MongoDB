package com.recipe.springcourse5.recipe.commands;

import com.recipe.springcourse5.recipe.models.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;
    private Recipe recipe;
}
