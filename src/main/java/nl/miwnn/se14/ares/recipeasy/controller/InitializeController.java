package nl.miwnn.se14.ares.recipeasy.controller;

import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import nl.miwnn.se14.ares.recipeasy.service.RecipeUserService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.Set;

/**
 * @author armazadev
 * Set some intial data in the database for testing purposes
 */
@Controller
public class InitializeController {
    private final RecipeUserService userService;
    private final RecipeUserRepository recipeUserRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public InitializeController(RecipeUserService userService, RecipeUserRepository recipeUserRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.userService = userService;
        this.recipeUserRepository = recipeUserRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent ignoredEvent) {
        if (userService.getAllUsers().isEmpty()) {
            initializeDB();
        }
    }

    private void initializeDB() {
        makeRecipeUser("Admin", "Admin");

//        Ingredient Garlic = makeIngredient("Garlic");
//        Ingredient Thyme = makeIngredient("Thyme");
//        Ingredient Rosemary = makeIngredient("Rosemary");
//
//
//        makeRecipe("Ovenbaked Chicken", "Step 1: marinate the chicken. Step 2 set the oven to 300 degrees", 60, Thyme, Garlic, Rosemary);
//        makeRecipe("Italian style pizza", "Step 1: Season the douch.", 30, Thyme, Garlic, Rosemary);


    }


    private Recipe makeRecipe(String name, String description, int cookTime, Ingredient ... ingredients) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCookTime(cookTime);

        Set<Ingredient> ingredientSet = new HashSet<>();
        recipe.setIngredients(ingredientSet);

        recipeRepository.save(recipe);
        return recipe;

    }
    private Ingredient makeIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);

        Set<Ingredient> ingredientSet = new HashSet<>();
        ingredientSet.add(ingredient);

        ingredientRepository.save(ingredient);
        return ingredient;

    }

    private RecipeUser makeRecipeUser(String username, String password) {
        RecipeUser user = new RecipeUser();
        user.setUsername(username);
        user.setPassword(password);
        userService.save(user);
        return user;
    }

}
