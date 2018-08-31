package com.recipe.springcourse5.recipe.repositories;

import com.recipe.springcourse5.recipe.bootstrap.RecipeBootstrap;
import com.recipe.springcourse5.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureRepositoryIT {

    /*
     * This testclass performe some Integrations tests.
     * @RunWith(SpringRunner.class) implies that the spring context will be loaded.
     * @DataJpaTest will bring up an embeded databse and at the same time configure Spring data jpa.
     * */

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Before
    public void setUp() throws Exception {
        RecipeBootstrap recipeBootstrap = new RecipeBootstrap(categoryRepository, recipeRepository, unitOfMeasureRepository, userInfoRepository);
        recipeBootstrap.onApplicationEvent(null);
    }

    /*
     * Run whole testclass and notice that findByDescriptionTeaspoon will take significantly
     * longer time than findByDescriptionCup.
     * Thats because Spring context is loaded at the begining for the first test to run and instead of loading is once
     * again it will be reused.
     * */

    @Test
    public void findByDescriptionTeaspoon() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasure.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", unitOfMeasure.get().getDescription());
    }
}