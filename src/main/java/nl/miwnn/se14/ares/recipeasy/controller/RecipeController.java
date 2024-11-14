package nl.miwnn.se14.ares.recipeasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author Johannes
 * Handles all requests primarily related to recipes
 */
@Controller
public class RecipeController {

    @GetMapping("/")
    private String showHomepage(Model model) {
        List<String> cuisines = Arrays.asList("Italian", "Mexican", "Japanese", "Indian", "French", "All");
        model.addAttribute("cuisines", cuisines);

        return "homepage";
    }

    @GetMapping("/recipe/overview")
    private String showRecipeOverview() {
        return "recipeOverview";
    }

}
