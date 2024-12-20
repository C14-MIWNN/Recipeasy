package nl.miwnn.se14.ares.recipeasy.controller;

import jakarta.validation.Valid;
import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import nl.miwnn.se14.ares.recipeasy.service.RecipeUserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * @author armankhodadadzade
 * Purpose
 */
@Controller
@RequestMapping("/user")
public class RecipeUserController {
    private final RecipeUserService recipeUserService;
    private final RecipeUserRepository recipeUserRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    public RecipeUserController(RecipeUserService recipeUserService, RecipeUserRepository recipeUserRepository, RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeUserService = recipeUserService;
        this.recipeUserRepository = recipeUserRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/profile")
    public String showUserProfile(Model datamodel) {
        RecipeUserDTO currentUser = recipeUserService.getCurrentUser();
        RecipeUser user = new RecipeUser();
        datamodel.addAttribute("user", currentUser);
        List<Recipe> userRecipes = List.of();
        datamodel.addAttribute("userRecipes", userRecipes);
        datamodel.addAttribute("newRecipe", new Recipe());
        datamodel.addAttribute("formRecipe", new Recipe());
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());
        datamodel.addAttribute("allIngredients", ingredientRepository.findAll());

        RecipeUser recipeAuthor = recipeUserRepository.findByUsername(currentUser.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        userRecipes = recipeRepository.findByRecipeAuthor(recipeAuthor);
        datamodel.addAttribute("user", currentUser);
        datamodel.addAttribute("userRecipes", userRecipes);
        datamodel.addAttribute("newRecipe", new Recipe());


        return "userProfile";
    }

//      We might use this later if we want to give Admins the ability to see a list of registered users
//    @GetMapping("/overview")
//    private String showUserOverview(Model datamodel) {
//        datamodel.addAttribute("allUsers", recipeUserService.getAllUsers());
//        datamodel.addAttribute("formUser", new RecipeUserDTO());
//        datamodel.addAttribute("formModalHidden", true);
//
//        return "userOverview";
//    }

    @PostMapping("/save")
    private String saveOrUpdateUser(@ModelAttribute("formUser") @Valid RecipeUserDTO userDtoToBeSaved, BindingResult result,
                                    Model datamodel) {
        if (recipeUserService.usernameInUse(userDtoToBeSaved.getUsername())) {
            result.rejectValue("username", "duplicate", "This username is not available");
        }

        if (!userDtoToBeSaved.getPassword().equals(userDtoToBeSaved.getPasswordConfirm())) {
            System.out.println("Passwords do not match.");
            result.rejectValue("password", "no.match", "The passwords do not match");
        }

        if (result.hasErrors()) {
            datamodel.addAttribute("allUsers", recipeUserService.getAllUsers());
            datamodel.addAttribute("searchForm", new Recipe());
            datamodel.addAttribute("formModalHidden", false);
            datamodel.addAttribute("formRecipe", new Recipe());

            return "registerForm";
        }

        userDtoToBeSaved.setRole("USER");

        recipeUserService.save(userDtoToBeSaved);
        return "redirect:/user/welcome";
    }

    @GetMapping("/welcome")
    public String showWelcome(Model datamodel) {
        RecipeUserDTO currentUser = recipeUserService.getCurrentUser();
        RecipeUser user = new RecipeUser();
        datamodel.addAttribute("user", currentUser);
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("searchForm", new Recipe());
        datamodel.addAttribute("recipe", new Recipe());
        datamodel.addAttribute("formRecipe", new Recipe());
        datamodel.addAttribute("allIngredients", ingredientRepository.findAll());
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model datamodel) {
        datamodel.addAttribute("user", new RecipeUserDTO());
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);
        datamodel.addAttribute("formRecipe", new Recipe());
        return "registerForm";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid RecipeUserDTO userDTO, BindingResult result, Model datamodel) {
        System.out.println("Attempting to register user: " + userDTO.getUsername());

        if (recipeUserService.usernameInUse(userDTO.getUsername())) {
            result.rejectValue("username", "duplicate", "This username is already taken.");
        }


        if (!userDTO.getPassword().equals(userDTO.getPasswordConfirm())) {
            System.out.println("Username already in use.");
            result.rejectValue("password", "no.match", "The passwords do not match");
        }

        if (result.hasErrors()) {
            datamodel.addAttribute("formUser", userDTO);
            datamodel.addAttribute("formModalHidden", false);
            datamodel.addAttribute("formRecipe", new Recipe());
            return "registerForm";
        }

        userDTO.setRole("USER");

        recipeUserService.save(userDTO);
        return "redirect:/user/welcome";
    }



}
