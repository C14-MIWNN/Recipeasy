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
    private String title;
    private String shortDescription;
    private String prepTime;
    private String instructions;
    private String imageUrl;

    @NotBlank
    @Column(unique = true)
    private String name;

    @ManyToMany
    private Set<RecipeUser> likedByUserSet;

    @ManyToOne
    private RecipeUser recipeAuthor;

    @Column
    private String displayName;

    @Column
    private int cookTime;

    @ManyToMany
    @NotEmpty
    private Set<Ingredient> ingredients;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String cookingSteps;

    // GETTERS AND SETTERS
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

