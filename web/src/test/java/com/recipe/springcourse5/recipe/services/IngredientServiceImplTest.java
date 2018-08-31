package com.recipe.springcourse5.recipe.services;

import com.recipe.springcourse5.recipe.commands.IngredientCommand;
import com.recipe.springcourse5.recipe.converters.IngredientCommandToIngredient;
import com.recipe.springcourse5.recipe.converters.IngredientToIngredientCommand;
import com.recipe.springcourse5.recipe.converters.UnitOfMeasureCommandToUnitOfMeasure;
import com.recipe.springcourse5.recipe.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.recipe.springcourse5.recipe.models.Ingredient;
import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import com.recipe.springcourse5.recipe.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    //TODO Write test for saveIngredientCommand.

    //init converters
    @Autowired
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private IngredientService ingredientService;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient,
                recipeRepository, unitOfMeasureRepository);
    }

    @Test
    public void findByRecipeIdAndId() throws Exception {
    }

    @Test
    public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
        //given
        Recipe recipe = new Recipe();
        recipe.setId("1");

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId("1");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId("1");

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId("1");

        recipe.addIngredient(ingredient1);
        recipe.addIngredient(ingredient2);
        recipe.addIngredient(ingredient3);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById("1")).thenReturn(recipeOptional);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId("1", "3");

        //when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf("1"), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById("1");
    }

    @Test
    public void testSaveRecipeCommand() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId("3");
        command.setRecipeId("2");

        Optional<Recipe> recipeOptional = Optional.of(new Recipe());

        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredient(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId("3");

        when(recipeRepository.findById("1")).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        //when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        //then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById("1");
        verify(recipeRepository, times(1)).save(any(Recipe.class));

    }

}