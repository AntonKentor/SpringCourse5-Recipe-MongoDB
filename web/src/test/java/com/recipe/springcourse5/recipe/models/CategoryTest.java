package com.recipe.springcourse5.recipe.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        category = new Category();
    }

    @Test
    public void getId() {
        String idValue = "4";
        category.setId(idValue);
        Assert.assertEquals(idValue, category.getId());
    }

    @Test
    public void getRecipes() {
    }

    @Test
    public void getDescription() {
    }
}