package com.recipe.springcourse5.recipe.repositories;


import com.recipe.springcourse5.recipe.models.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeRepositoryIT {

    @Autowired
    private RecipeRepository recipeRepository;

    @Before
    public void setup() throws Exception {
        recipeRepository.deleteAll().block();

    }

    @Test
    public void testRecipeSave() {
        Recipe recipe = new Recipe();
        recipe.setDescription("Yummy");

        recipeRepository.save(recipe).block();

        Long count = recipeRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

}
