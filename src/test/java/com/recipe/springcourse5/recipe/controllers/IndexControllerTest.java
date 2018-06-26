package com.recipe.springcourse5.recipe.controllers;

import com.recipe.springcourse5.recipe.models.Recipe;
import com.recipe.springcourse5.recipe.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    private final static String INDEX_PAGE = "/recipe/list.html";

    private IndexController indexController;
    @Mock
    private Model model;
    @Mock
    private RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        Set<Recipe> recipeSet = new HashSet<>();
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);

        recipeSet.add(recipe1);
        recipeSet.add(new Recipe());

        // Mock method call.
        when(recipeService.getRecipes()).thenReturn(recipeSet);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        String viewName = indexController.getIndexPage(model);
        assertEquals(INDEX_PAGE, viewName);

        //Verify the number of calls to the method.
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }

    @Test
    public void testMockMvc() throws Exception {

        //Tests that the correct page is displayed when calling controller specific url.
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

        mockMvc.perform(get(""))
                .andExpect(status().isOk())
                .andExpect(view().name(INDEX_PAGE));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(INDEX_PAGE));

        mockMvc.perform(get("/recipe/list"))
                .andExpect(status().isOk())
                .andExpect(view().name(INDEX_PAGE));

    }
}