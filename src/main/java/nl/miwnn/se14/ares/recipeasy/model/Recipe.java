package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

/**
 * @author Johannes
 * Making recipes
 */
@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int cookTime;

    @ManyToMany
    @NotEmpty
    private Set<Ingredient> ingredients;
}

