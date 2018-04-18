package com.recipe.springcourse5.recipe.commands;

import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure unitOfMeasure;
    private Recipe recipe;
}
