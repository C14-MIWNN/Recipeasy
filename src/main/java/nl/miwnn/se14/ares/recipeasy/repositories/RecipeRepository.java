package nl.miwnn.se14.ares.recipeasy.repositories;

import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByName(String name);

    Optional<List<Recipe>> findByNameContaining(String name);
}
