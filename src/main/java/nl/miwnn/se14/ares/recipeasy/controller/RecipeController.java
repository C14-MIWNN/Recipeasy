package nl.miwnn.se14.ares.recipeasy.controller;

import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Johannes
 * Handles all requests primarily related to recipes
 */
@Controller
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/")
    private String showHomepage(Model datamodel) {
        List<String> cuisines = Arrays.asList("Italian", "Mexican", "Japanese", "Indian", "French", "All");
        datamodel.addAttribute("cuisines", cuisines);
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);


        return "homepage";
    }

    @GetMapping("/recipe/overview")
    private String showRecipeOverview() {
        return "recipeOverview";
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
}
