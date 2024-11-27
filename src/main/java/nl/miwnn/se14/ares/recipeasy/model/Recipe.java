package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Locale;
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
    private String dbName;
    private String title;
    private Integer cookTime;
    private Integer prepTime;

    @ManyToMany
    private Set<RecipeUser> likedByUserSet;

    @ManyToOne
    private RecipeUser recipeAuthor;

    @ManyToMany
    private Set<Ingredient> ingredients;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String cookingSteps;

    private String imageUrl;

    // GETTERS AND SETTERS

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Set<RecipeUser> getLikedByUserSet() {
        return likedByUserSet;
    }

    public void setLikedByUserSet(Set<RecipeUser> likedByUserSet) {
        this.likedByUserSet = likedByUserSet;
    }

    public RecipeUser getRecipeAuthor() {
        return recipeAuthor;
    }

    public void setRecipeAuthor(RecipeUser recipeAuthor) {
        this.recipeAuthor = recipeAuthor;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(String cookingSteps) {
        this.cookingSteps = cookingSteps;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

