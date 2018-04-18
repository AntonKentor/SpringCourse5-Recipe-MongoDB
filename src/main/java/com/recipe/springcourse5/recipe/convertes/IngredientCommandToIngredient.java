package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.IngredientCommand;
import com.recipe.springcourse5.recipe.models.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setDescription(source.getDescription());
        ingredient.setAmount(source.getAmount());
        ingredient.setUnitOfMeasure(source.getUnitOfMeasure());
        ingredient.setRecipe(source.getRecipe());
        return ingredient;
    }
}
