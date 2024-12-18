package nl.miwnn.se14.ares.recipeasy.repositories;

import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByDbName(String dbName);
    List<Recipe> findByRecipeAuthor(RecipeUser recipeAuthor);
    Optional<List<Recipe>> findByDbNameContaining(String dbName);
}
