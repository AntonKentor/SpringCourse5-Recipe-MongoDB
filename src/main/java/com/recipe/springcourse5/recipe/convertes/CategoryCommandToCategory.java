package com.recipe.springcourse5.recipe.convertes;

import com.recipe.springcourse5.recipe.commands.CategoryCommand;
import com.recipe.springcourse5.recipe.models.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setRecipes(source.getRecipes());
        category.setDescription(source.getDescription());
        return category;

    }
}
