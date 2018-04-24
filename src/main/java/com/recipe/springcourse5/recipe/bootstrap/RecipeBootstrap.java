package com.recipe.springcourse5.recipe.bootstrap;

import com.recipe.springcourse5.recipe.enums.Difficulty;
import com.recipe.springcourse5.recipe.models.*;
import com.recipe.springcourse5.recipe.repositories.CategoryRepository;
import com.recipe.springcourse5.recipe.repositories.RecipeRepository;
import com.recipe.springcourse5.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    /*
    * This method is invoked first when application context gets initialized or refreshed.
    * Since class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>
    * and override onApplicationEvent where the initial recipes are created
    * and saved, according to the method.
    *
    * */
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("In onApplicationEvent, creates recipes for Bootstrap.");
        recipeRepository.saveAll(getRecipes());
    }

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();


        Optional<UnitOfMeasure> tableSpoonUnitOfMeasure = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tableSpoonUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> teaspoonUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaspoonUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }


        Optional<UnitOfMeasure> pintUnitOfMeasure = unitOfMeasureRepository.findByDescription("Pint");

        if (!pintUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> ounceUnitOfMeasure = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> eachUnitOfMeasure = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> pinchUnitOfMeasure = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> cupUnitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");

        if (!cupUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<UnitOfMeasure> dashUnitOfMeasure = unitOfMeasureRepository.findByDescription("Dash");

        if (!dashUnitOfMeasure.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        UnitOfMeasure teaspoon = teaspoonUnitOfMeasure.get();
        UnitOfMeasure tablespoon = tableSpoonUnitOfMeasure.get();
        UnitOfMeasure each = eachUnitOfMeasure.get();
        UnitOfMeasure dash = dashUnitOfMeasure.get();
        UnitOfMeasure pint = pintUnitOfMeasure.get();
        UnitOfMeasure cup = cupUnitOfMeasure.get();
        UnitOfMeasure pinch = pinchUnitOfMeasure.get();
        UnitOfMeasure ounce = ounceUnitOfMeasure.get();


        Optional<Category> americanCategory = categoryRepository.findByDescription("American");

        if (!americanCategory.isPresent()) {
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategory = categoryRepository.findByDescription("Italian");

        if (!italianCategory.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<Category> mexicanCategory = categoryRepository.findByDescription("Mexican");

        if (!mexicanCategory.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Optional<Category> fastfoodCategory = categoryRepository.findByDescription("Fast food");

        if (!fastfoodCategory.isPresent()) {
            throw new RuntimeException("Expected UnitOfMeasure not found");
        }

        Category american = americanCategory.get();
        Category italian = italianCategory.get();
        Category mexican = mexicanCategory.get();
        Category fastFood = fastfoodCategory.get();

        Recipe guacamoleRecipe = new Recipe();
        guacamoleRecipe.setDescription("Perfect Guacamole");
        guacamoleRecipe.setPrepTime(10);
        guacamoleRecipe.setCookTime(10);
        guacamoleRecipe.setDifficulty(Difficulty.EASY);
        guacamoleRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl." +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky." +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        Notes guacamoleNotes = new Notes();
        guacamoleNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");

        guacamoleRecipe.setNotes(guacamoleNotes);

        guacamoleRecipe.addIngredient(new Ingredient("Ripe avocados", new BigDecimal(2), each));
        guacamoleRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(5), teaspoon));
        guacamoleRecipe.addIngredient(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), tablespoon));
        guacamoleRecipe.addIngredient(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(2), each));
        guacamoleRecipe.addIngredient(new Ingredient("Serrano chiles, stems and seeds removed minced", new BigDecimal(2), each));
        guacamoleRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoon));
        guacamoleRecipe.addIngredient(new Ingredient("Freshly grated black pepper", new BigDecimal(2), dash));
        guacamoleRecipe.addIngredient(new Ingredient("Ripe tomato seeds and pulp removed, chopped", new BigDecimal(5), each));

        guacamoleRecipe.getCategories().add(american);
        guacamoleRecipe.getCategories().add(mexican);


        Recipe grilledChickenRecipe = new Recipe();
        grilledChickenRecipe.setDescription("Spicy grilled chicken tacos");
        grilledChickenRecipe.setCookTime(9);
        grilledChickenRecipe.setPrepTime(20);
        grilledChickenRecipe.setDifficulty(Difficulty.HARD);
        grilledChickenRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n 3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        Notes grilledChickenNotes = new Notes();
        grilledChickenNotes.setRecipeNotes("\n" +
                "BY SALLY VARGAS\n" +
                "May 22, 2017\n" +
                "Jump to Recipe\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "xxxxxyyyyy15 comments\n" +
                "dinnergrillquick and easychicken\n" +
                "Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "Photography Credit: Sally Vargas\n" +
                "We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "\n" +
                "\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!");

        grilledChickenRecipe.setNotes(grilledChickenNotes);

        grilledChickenRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Dried cumin", new BigDecimal(1), teaspoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(5), teaspoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Clove of garlic, chopped", new BigDecimal(1), each));
        grilledChickenRecipe.addIngredient(new Ingredient("finely grated orance zestr", new BigDecimal(1), tablespoon));
        grilledChickenRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Olive oil", new BigDecimal(2), tablespoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Boneless chicken thighs", new BigDecimal(4), tablespoon));
        grilledChickenRecipe.addIngredient(new Ingredient("Small corn tortillas", new BigDecimal(8), each));
        grilledChickenRecipe.addIngredient(new Ingredient("Packed baby arugula ", new BigDecimal(8), each));
        grilledChickenRecipe.getCategories().add(american);
        grilledChickenRecipe.getCategories().add(mexican);
        grilledChickenRecipe.getCategories().add(fastFood);

        recipes.add(guacamoleRecipe);
        recipes.add(grilledChickenRecipe);

        return recipes;

    }

}
