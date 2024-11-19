package nl.miwnn.se14.ares.recipeasy.controller;

import jakarta.validation.Valid;
import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.service.RecipeUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author armankhodadadzade
 * Purpose
 */
@Controller
@RequestMapping("/user")
public class RecipeUserController {
    private final RecipeUserService recipeUserService;

    public RecipeUserController(RecipeUserService recipeUserService) {
        this.recipeUserService = recipeUserService;
    }

    @GetMapping("/profile")
    public String showUserProfile(Model datamodel) {
        RecipeUserDTO currentUser = recipeUserService.getCurrentUser();
        datamodel.addAttribute("user", currentUser);
        return "userProfile";
    }


    @GetMapping("/overview")
    private String showUserOverview(Model datamodel) {
        datamodel.addAttribute("allUsers", recipeUserService.getAllUsers());
        datamodel.addAttribute("formUser", new RecipeUserDTO());
        datamodel.addAttribute("formModalHidden", true);

        return "userOverview";
    }

    @PostMapping("/save")
    private String saveOrUpdateUser(@ModelAttribute("formUser") @Valid RecipeUserDTO userDtoToBeSaved, BindingResult result,
                                    Model datamodel) {
        if (recipeUserService.usernameInUse(userDtoToBeSaved.getUsername())) {
            result.rejectValue("username", "duplicate", "This username is not available");
        }

        if (!userDtoToBeSaved.getPassword().equals(userDtoToBeSaved.getPasswordConfirm())) {
            result.rejectValue("password", "no.match", "The passwords do not match");
        }

        if (result.hasErrors()) {
            datamodel.addAttribute("allUsers", recipeUserService.getAllUsers());
            datamodel.addAttribute("formModalHidden", false);
            return "userOverview";
        }

        recipeUserService.save(userDtoToBeSaved);
        return "redirect:/user/overview";
    }

//    @PostMapping("/register")
//    public String registerUser(@RequestBody RecipeUserDTO userDTO) {
//        if (recipeUserService.usernameInUse(userDTO.getUsername())) {
//            return "Username already in use.";
//        }
//
//        recipeUserService.save(userDTO);
//        return "User registered successfully!";
//    }


}
