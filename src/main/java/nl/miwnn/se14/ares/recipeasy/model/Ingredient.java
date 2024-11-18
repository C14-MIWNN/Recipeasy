package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Set;

/**
 * @author Johannes
 * Ingredients that can go into recipes
 */
@Entity
public class Ingredient {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
