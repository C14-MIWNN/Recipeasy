package nl.miwnn.se14.ares.recipeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Johannes
 * Handles all requests primarily related to recipes
 */
@Controller
public class RecipeController {

    @GetMapping({"/", "/recipe/overview"})
    private String showRecipeOverview() {
        return "recipeOverview";
    }
}
