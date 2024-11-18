package nl.miwnn.se14.ares.recipeasy.repositories;

import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Optional<Ingredient> findByName(String name);
}
