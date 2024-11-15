package nl.miwnn.se14.ares.recipeasy.repositories;

import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author armazadev
 * Purpose
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    Optional<Ingredient> findByName(String name);
}
