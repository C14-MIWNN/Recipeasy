package nl.miwnn.se14.ares.recipeasy.controller;

import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.model.CuisineType;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Johannes
 * Handles all requests primarily related to recipes
 */
@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final RecipeUserRepository recipeUserRepository;

    public RecipeController(RecipeRepository recipeRepository,
                            IngredientRepository ingredientRepository,
                            RecipeUserRepository recipeUserRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeUserRepository = recipeUserRepository;
    }

    @GetMapping("/")
    private String showHomepage(Model datamodel) {
        List<String> cuisineTypes = Arrays.asList("Italian", "Mexican", "Japanese", "Indian", "French", "All");
        datamodel.addAttribute("cuisineTypes", cuisineTypes);
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());
        datamodel.addAttribute("allIngredients", ingredientRepository.findAll());

        return "homepage";
    }

    @GetMapping("/recipe/overview")
    private String showRecipeOverview(Model datamodel) {
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }

    @GetMapping("/recipe/overview/{cuisine}")
    private String showRecipesByCuisineType(@PathVariable("cuisine") CuisineType cuisineType,
                                            BindingResult result,
                                            Model datamodel) {
        Optional<List<Recipe>> searchResults = recipeRepository.findByCuisineType(cuisineType);

        if (searchResults.isEmpty()) {
            result.rejectValue("name", "search.results.empty",
                    "Our site appears to have no recipes from this cuisine. " +
                            "Maybe you can add a recipe from this cuisine!");
        }

        if (result.hasErrors()) {
            return "homepage";
        }

        datamodel.addAttribute("allRecipes", searchResults.get()) ;
        return "recipeOverview";
    }

    @PostMapping("/search")
    private String showRecipesBySearchTerm(
            @ModelAttribute("searchForm") Recipe recipe,
            BindingResult result,
            Model datamodel) {

        Optional<List<Recipe>> searchResults = recipeRepository.findByDbNameContaining(recipe.getDbName());

        if (searchResults.isEmpty()) {
            result.rejectValue("dbName", "search.results.empty",
                    "We found no recipes with your search term. " +
                            "Try a different search term, or maybe you would like to add this recipe yourself!");
        }

        if (result.hasErrors()) {
            return "homepage";
        }

        datamodel.addAttribute("allRecipes", searchResults.get());
        return "recipeOverview";
    }

    @GetMapping("/recipe/detail/{recipeName}")
    private String showRecipeDetailPage(@PathVariable("recipeName") String recipeName, Model datamodel) {
        Optional<Recipe> recipe = recipeRepository.findByDbName(recipeName);
        if (recipe.isEmpty()) {
            return "redirect:/recipe/overview";
        }
        datamodel.addAttribute("recipeToBeShown", recipe.get());
        return "recipeDetail";
    }

    @PostMapping("/recipe/add")
    public String addRecipe(@ModelAttribute Recipe recipe, BindingResult bindingResult, Model datamodel) {
        RecipeUser currentUser = (RecipeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recipe.setRecipeAuthor(currentUser);
        datamodel.addAttribute("recipe", recipe);
        datamodel.addAttribute("user", currentUser);
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());
        if (bindingResult.hasErrors()) {
            datamodel.addAttribute("formRecipe", recipe);
            return "userProfile";  // Return to the same page to display errors
        }
        recipe.setDbName(turnRecipeTitleIntoDbName(recipe.getTitle()));

        recipeRepository.save(recipe);

        datamodel.addAttribute("message", "Recipe added successfully!");
        return "redirect:/recipe/overview";
    }

    public String turnRecipeTitleIntoDbName(String title) {
        return title.toLowerCase().replace(" ", "_");
    }
}
