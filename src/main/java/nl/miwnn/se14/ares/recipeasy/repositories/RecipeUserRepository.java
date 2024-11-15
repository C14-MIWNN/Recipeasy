package nl.miwnn.se14.ares.recipeasy.repositories;

import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeUserRepository extends JpaRepository<RecipeUser, Long> {
    Optional<RecipeUser> findByUsername(String username);
}
