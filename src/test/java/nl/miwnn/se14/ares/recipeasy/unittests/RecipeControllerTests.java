package nl.miwnn.se14.ares.recipeasy.unittests;

import nl.miwnn.se14.ares.recipeasy.controller.RecipeController;
import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Johannes
 * Tests to check if our code does what it is supposed to do
 */
public class RecipeControllerTests {

    @Test
    void checkRemovalOfWhitespacesFromRecipeTitle() {

        // Arrange
        RecipeRepository recipeRepository = new RecipeRepository() {
            @Override
            public Optional<Recipe> findByDbName(String dbName) {
                return Optional.empty();
            }

            @Override
            public List<Recipe> findByRecipeAuthor(RecipeUser recipeAuthor) {
                return List.of();
            }

            @Override
            public Optional<List<Recipe>> findByDbNameContaining(String dbName) {
                return Optional.empty();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Recipe> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Recipe> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Recipe getOne(Long aLong) {
                return null;
            }

            @Override
            public Recipe getById(Long aLong) {
                return null;
            }

            @Override
            public Recipe getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Recipe> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<Recipe> findAll() {
                return List.of();
            }

            @Override
            public List<Recipe> findAllById(Iterable<Long> longs) {
                return List.of();
            }

            @Override
            public <S extends Recipe> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Recipe> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Recipe entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Recipe> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Recipe> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Recipe> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Recipe> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Recipe> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Recipe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        IngredientRepository ingredientRepository = new IngredientRepository() {
            @Override
            public Optional<Ingredient> findByName(String name) {
                return Optional.empty();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Ingredient> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Ingredient> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Ingredient getOne(Integer integer) {
                return null;
            }

            @Override
            public Ingredient getById(Integer integer) {
                return null;
            }

            @Override
            public Ingredient getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<Ingredient> findAll() {
                return List.of();
            }

            @Override
            public List<Ingredient> findAllById(Iterable<Integer> integers) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Ingredient> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Ingredient entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Ingredient> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Ingredient> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Ingredient> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Ingredient> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Ingredient> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Ingredient, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };

        RecipeController recipeController = new RecipeController(
                recipeRepository,
                ingredientRepository);

        // Act
        String dbName = recipeController.turnRecipeTitleIntoDbName("stamppot boerenkool met worst");

        // Assert
        assertEquals("stamppot_boerenkool_met_worst", dbName);
    }

    @Test
    void checkRemovalOfCapitalsFromRecipeTitle() {

        // Arrange
        RecipeRepository recipeRepository = new RecipeRepository() {
            @Override
            public Optional<Recipe> findByDbName(String dbName) {
                return Optional.empty();
            }

            @Override
            public List<Recipe> findByRecipeAuthor(RecipeUser recipeAuthor) {
                return List.of();
            }

            @Override
            public Optional<List<Recipe>> findByDbNameContaining(String dbName) {
                return Optional.empty();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Recipe> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Recipe> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Recipe getOne(Long aLong) {
                return null;
            }

            @Override
            public Recipe getById(Long aLong) {
                return null;
            }

            @Override
            public Recipe getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Recipe> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Recipe> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<Recipe> findAll() {
                return List.of();
            }

            @Override
            public List<Recipe> findAllById(Iterable<Long> longs) {
                return List.of();
            }

            @Override
            public <S extends Recipe> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Recipe> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Recipe entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Recipe> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Recipe> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Recipe> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Recipe> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Recipe> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Recipe> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Recipe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
        IngredientRepository ingredientRepository = new IngredientRepository() {
            @Override
            public Optional<Ingredient> findByName(String name) {
                return Optional.empty();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Ingredient> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> saveAllAndFlush(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public void deleteAllInBatch(Iterable<Ingredient> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Integer> integers) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Ingredient getOne(Integer integer) {
                return null;
            }

            @Override
            public Ingredient getById(Integer integer) {
                return null;
            }

            @Override
            public Ingredient getReferenceById(Integer integer) {
                return null;
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> List<S> findAll(Example<S> example, Sort sort) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> List<S> saveAll(Iterable<S> entities) {
                return List.of();
            }

            @Override
            public List<Ingredient> findAll() {
                return List.of();
            }

            @Override
            public List<Ingredient> findAllById(Iterable<Integer> integers) {
                return List.of();
            }

            @Override
            public <S extends Ingredient> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Ingredient> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Ingredient entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Integer> integers) {

            }

            @Override
            public void deleteAll(Iterable<? extends Ingredient> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Ingredient> findAll(Sort sort) {
                return List.of();
            }

            @Override
            public Page<Ingredient> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Ingredient> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Ingredient> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Ingredient> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Ingredient, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };

        RecipeController recipeController = new RecipeController(
                recipeRepository,
                ingredientRepository);

        // Act
        String dbName = recipeController.turnRecipeTitleIntoDbName("Macaroni");

        // Assert
        assertEquals("macaroni", dbName);
    }


}
