package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @Id
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @NotEmpty
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
