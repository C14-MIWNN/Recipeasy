package nl.miwnn.se14.ares.recipeasy.controller;

import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
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

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/")
    private String showHomepage(Model datamodel) {

        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());
        datamodel.addAttribute("formRecipe", new Recipe());
        datamodel.addAttribute("newRecipe", new Recipe());
        datamodel.addAttribute("searchRecipe", new Recipe());
        datamodel.addAttribute("allIngredients", ingredientRepository.findAll());
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
        datamodel.addAttribute("newIngredient", new Ingredient());

        List<Recipe> randomRecipes = getRandomRecipes(4);

        datamodel.addAttribute("randomRecipes", randomRecipes);

        return "homepage";
    }

    @GetMapping("/recipe/overview")
    private String showRecipeOverview(Model datamodel) {
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
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

    @GetMapping("/recipe/delete/{recipeId}")
    private String removeRecipeByName(@PathVariable("recipeId") Long recipeId, Model datamodel) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if (recipe.isEmpty()) {
            return "redirect:/recipe/overview";
        }
        recipeRepository.deleteById(recipeId);
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
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

    @GetMapping("/ingredient/new")
    private String showNewIngredientForm(Model datamodel) {
        datamodel.addAttribute("formIngredient", new Ingredient());

        return "newIngredientForm";
    }

    @PostMapping("/ingredient/save")
    private String saveIngredient(@ModelAttribute("formIngredient") Ingredient ingredientToBeSaved, Model datamodel, BindingResult result) {
        if (result.hasErrors()) {
            System.err.println(result.getAllErrors());
            return "redirect:/ingredient/new";
        }

        ingredientRepository.save(ingredientToBeSaved);
        datamodel.addAttribute("allRecipes", recipeRepository.findAll());
        return "redirect:/recipe/overview";
    }

    public String turnRecipeTitleIntoDbName(String title) {
        return title.toLowerCase().replace(" ", "_").replaceAll("[^a-zA-Z]", "");
    }

    public List<Recipe> getRandomRecipes(int numberOfRecipes) {
        List<Recipe> allRecipes = recipeRepository.findAll();
        Collections.shuffle(allRecipes);
        ArrayList<Recipe> randomRecipes = new ArrayList<>();

        for (int recipeIndex = 0; recipeIndex < numberOfRecipes && recipeIndex < allRecipes.size(); recipeIndex++) {
            randomRecipes.add(allRecipes.get(recipeIndex));
        }
        return randomRecipes;
    }
}
