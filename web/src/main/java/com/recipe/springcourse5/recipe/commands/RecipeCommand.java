package com.recipe.springcourse5.recipe.commands;

import com.recipe.springcourse5.recipe.enums.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private String id;

    @NotBlank
    @Size(min = 3, max = 55)
    private String description;

    @Min(1)
    @Max(999)
    private Integer prepTime;

    @Min(1)
    @Max(999)
    private Integer cookTime;

    @Min(1)
    @Max(100)
    private Integer servings;

    @URL
    @NotBlank
    private String url;

    @NotBlank
    private String directions;

    private String source;
    private List<IngredientCommand> ingredients = new ArrayList<>();
    private Difficulty difficulty;
    private NotesCommand notes = new NotesCommand();
    private Byte[] image;
    private List<CategoryCommand> categories = new ArrayList<>();
}
