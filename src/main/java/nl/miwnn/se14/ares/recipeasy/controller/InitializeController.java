package nl.miwnn.se14.ares.recipeasy.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
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

import javax.print.DocFlavor;
import java.util.*;

/**
 * @author armazadev
 * Set some intial data in the database for testing purposes
 */
@Controller
public class InitializeController {
    private final RecipeUserService userService;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public InitializeController(RecipeUserService userService, RecipeUserRepository recipeUserRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.userService = userService;
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

        Ingredient Garlic = makeIngredient("Garlic");
        Ingredient Thyme = makeIngredient("Thyme");
        Ingredient Rosemary = makeIngredient("Rosemary");
        Ingredient Chicken = makeIngredient("Chicken");
        Ingredient Beaf = makeIngredient("Beaf");
        Ingredient Pepper = makeIngredient("Pepper");
        Ingredient Salt = makeIngredient("Salt");
        Ingredient OliveOil = makeIngredient("Olive oil");
        Ingredient Vegetables = makeIngredient("Vegetables");

        Recipe chicken = makeRecipe("ovenbakedchicken", "Oven Baked Chicken", "1. Marinate the chicken.\n2. Set the oven at 300 degrees.", 60, "https://cdn.pixabay.com/photo/2024/01/19/12/16/chicken-8518910_1280.jpg", Chicken, Garlic, Rosemary);
        Recipe pizza = makeRecipe("italianpizza", "Italian style pizza", "1. Season the dough.", 30, "https://cdn.pixabay.com/photo/2024/03/01/08/44/pizza-8605916_1280.jpg", Thyme, Garlic, Rosemary);
        Recipe steak = makeRecipe("steak", "Juicy steak", "1. Step one./n2. Step two.", 15, "https://cdn.pixabay.com/photo/2024/08/04/15/47/ai-generated-8944735_1280.jpg", Beaf, Pepper, Salt);
        Recipe stirfry = makeRecipe("stirfry", "Stir Fry", "1. Step one./n2. Step two.", 30, "https://cdn.pixabay.com/photo/2024/02/22/06/50/wok-8589237_1280.png", Vegetables, OliveOil);
    }

    private Recipe makeRecipe(String name, String displayName, String cookingSteps, int cookTime, String imageUrl, Ingredient ... ingredients) {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDisplayName(displayName);
        recipe.setCookingSteps(cookingSteps);
        recipe.setCookTime(cookTime);
        recipe.setImageUrl(imageUrl);

        Set<Ingredient> recipeIngredients = new HashSet<>(Arrays.asList(ingredients));
        recipe.setIngredients(recipeIngredients);

        recipeRepository.save(recipe);
        return recipe;
    }

    private Ingredient makeIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);

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
