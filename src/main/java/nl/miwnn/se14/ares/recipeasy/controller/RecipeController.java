package nl.miwnn.se14.ares.recipeasy.controller;

import jakarta.validation.Valid;
import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import nl.miwnn.se14.ares.recipeasy.service.mapper.RecipeUserMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeUserRepository recipeUserRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeUserRepository = recipeUserRepository;
    }

    @GetMapping("/")
    private String showHomepage(Model datamodel) {
        List<String> cuisines = Arrays.asList("Italian", "Mexican", "Japanese", "Indian", "French", "All");
        datamodel.addAttribute("cuisines", cuisines);
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());


        return "homepage";
    }

    @GetMapping("/recipe/overview")
    private String showRecipeOverview() {
        return "recipeOverview";
    }

    @GetMapping("/recipe/overviewnew")
    private String showRecipeOverviewNew(Model datamodel) {
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverviewNew";
    }

    @PostMapping("/search")
    private String showRecipesBySearchTerm(
            @ModelAttribute("searchForm") Recipe recipe,
            BindingResult result,
            Model datamodel) {

        Optional<List<Recipe>> searchResults = recipeRepository.findByNameContaining(recipe.getName());

        if (searchResults.isEmpty()) {
            result.rejectValue("name", "search.results.empty",
                    "We found no recipes with your search term. Try a different search term, or maybe add this recipe yourself!");
        }

        if (result.hasErrors()) {
            return "homepage";
        }

        datamodel.addAttribute("allRecipes", searchResults.get());
        return "recipeOverviewNew";
    }

    @GetMapping("/recipe/detail/{recipeName}")
    private String showRecipeDetailPage(@PathVariable("recipeName") String recipeName, Model datamodel) {
        Optional<Recipe> recipe = recipeRepository.findByName(recipeName);
        if (recipe.isEmpty()) {
            return "redirect:/recipe/overview";
        }
        datamodel.addAttribute("recipeToBeShown", recipe.get());
        return "recipeDetail";
    }

    @PostMapping("/recipe/add")
    public String addRecipe(@ModelAttribute Recipe recipe, Model model) {
        RecipeUser currentUser = (RecipeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        recipe.setRecipeAuthor(currentUser);

        // Save the recipe
        recipeRepository.save(recipe);

        // Optionally, add a success message
        model.addAttribute("message", "Recipe added successfully!");
        return "redirect:/"; // Redirect to homepage after adding the recipe
    }


}
