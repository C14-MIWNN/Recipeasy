package nl.miwnn.se14.ares.recipeasy.controller;

import nl.miwnn.se14.ares.recipeasy.model.Ingredient;
import nl.miwnn.se14.ares.recipeasy.model.Recipe;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.IngredientRepository;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeRepository;
import nl.miwnn.se14.ares.recipeasy.service.RecipeUserService;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import javax.management.relation.Role;
import java.util.*;

/**
 * @author armazadev
 * Set some intial data in the database for testing purposes
 */
@Controller
public class InitializeController {
    private final RecipeUserService userService;
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public InitializeController(RecipeUserService userService,
                                IngredientRepository ingredientRepository,
                                RecipeRepository recipeRepository) {
        this.userService = userService;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent ignoredEvent) {
        if (userService.getAllUsers().isEmpty()) {
            initializeDB();
        }
    }

    private void initializeDB() {
        makeRecipeUser("Admin", "Admin", "ADMIN");

        Ingredient Garlic = makeIngredient("Garlic");
        Ingredient Thyme = makeIngredient("Thyme");
        Ingredient Rosemary = makeIngredient("Rosemary");
        Ingredient Chicken = makeIngredient("Chicken");
        Ingredient Beef = makeIngredient("Beef");
        Ingredient Pepper = makeIngredient("Pepper");
        Ingredient Salt = makeIngredient("Salt");
        Ingredient OliveOil = makeIngredient("Olive oil");
        Ingredient Vegetables = makeIngredient("Vegetables");
        Ingredient Basil = makeIngredient("Basil");
        Ingredient Black_Pepper = makeIngredient("Black Pepper");
        Ingredient Onion = makeIngredient("Onion");
        Ingredient Tomato = makeIngredient("Tomato");
        Ingredient Chicken_Breast = makeIngredient("Chicken Breast");
        Ingredient Pork = makeIngredient("Pork");
        Ingredient Salmon = makeIngredient("Salmon");
        Ingredient Lemon = makeIngredient("Lemon");
        Ingredient Butter = makeIngredient("Butter");
        Ingredient Flour = makeIngredient("Flour");
        Ingredient Sugar = makeIngredient("Sugar");
        Ingredient Eggs = makeIngredient("Eggs");
        Ingredient Milk = makeIngredient("Milk");
        Ingredient Cheese = makeIngredient("Cheese");
        Ingredient Pasta = makeIngredient("Pasta");
        Ingredient Rice = makeIngredient("Rice");
        Ingredient Potato = makeIngredient("Potato");
        Ingredient Carrot = makeIngredient("Carrot");
        Ingredient Celery = makeIngredient("Celery");
        Ingredient Bell_Pepper = makeIngredient("Bell Pepper");
        Ingredient Mushroom = makeIngredient("Mushroom");
        Ingredient Spinach = makeIngredient("Spinach");
        Ingredient Broccoli = makeIngredient("Broccoli");
        Ingredient Cauliflower = makeIngredient("Cauliflower");
        Ingredient Zucchini = makeIngredient("Zucchini");
        Ingredient Eggplant = makeIngredient("Eggplant");
        Ingredient Avocado = makeIngredient("Avocado");
        Ingredient Cilantro = makeIngredient("Cilantro");
        Ingredient Parsley = makeIngredient("Parsley");
        Ingredient Oregano = makeIngredient("Oregano");
        Ingredient Cumin = makeIngredient("Cumin");
        Ingredient Paprika = makeIngredient("Paprika");
        Ingredient Cinnamon = makeIngredient("Cinnamon");
        Ingredient Nutmeg = makeIngredient("Nutmeg");
        Ingredient Ginger = makeIngredient("Ginger");
        Ingredient Soy_Sauce = makeIngredient("Soy Sauce");
        Ingredient Vinegar = makeIngredient("Vinegar");
        Ingredient Honey = makeIngredient("Honey");
        Ingredient Mustard = makeIngredient("Mustard");
        Ingredient Mayonnaise = makeIngredient("Mayonnaise");
        Ingredient Ketchup = makeIngredient("Ketchup");
        Ingredient Worcestershire_Sauce = makeIngredient("Worcestershire Sauce");
        Ingredient Coconut_Milk = makeIngredient("Coconut Milk");
        Ingredient Heavy_Cream = makeIngredient("Heavy Cream");
        Ingredient Cucumber = makeIngredient("Cucumber");
        Ingredient Dill = makeIngredient("Dill");
        Ingredient Lime = makeIngredient("Lime");
        Ingredient Water = makeIngredient("Water");
        Ingredient Yogurt = makeIngredient("Yogurt");

        Recipe chicken = makeRecipe(
                "oven_baked_chicken",
                "Oven baked chicken",
                "1. Marinate the chicken. 2. Set the oven at 300 degrees.",
                30,
                60,
                "https://cdn.pixabay.com/photo/2024/01/19/12/16/chicken-8518910_1280.jpg",
                Chicken, Garlic, Rosemary);
        Recipe pizza = makeRecipe(
                "italian_pizza",
                "Italian style pizza",
                "1. Season the dough.",
                30,
                15,
                "https://cdn.pixabay.com/photo/2024/03/01/08/44/pizza-8605916_1280.jpg",
                Thyme, Garlic, Rosemary);
        Recipe steak = makeRecipe(
                "steak",
                "Juicy steak",
                "1. Step one. 2. Step two.",
                15,
                15,
                "https://cdn.pixabay.com/photo/2024/08/04/15/47/ai-generated-8944735_1280.jpg",
                Beef, Pepper, Salt);
        Recipe stirfry = makeRecipe(
                "stir_fry",
                "Stir fry",
                "1. Step one. 2. Step two.",
                5,
                30,
                "https://cdn.pixabay.com/photo/2024/02/22/06/50/wok-8589237_1280.png",
                Vegetables, OliveOil);
        Recipe roast_beef = makeRecipe(
                "roast_beef",
                "Roast Beef",
                "1. Season beef. 2. Sear in hot pan. 3. Roast in oven at 375°F. 4. Rest before slicing.",
                20,
                90,
                "https://cdn.pixabay.com/photo/2016/08/08/15/19/meat-1578495_1280.jpg",
                Beef, Garlic, Rosemary, Salt, Black_Pepper);

        Recipe tomato_soup = makeRecipe(
                "tomato_soup",
                "Tomato Soup",
                "1. Sauté onions and garlic. 2. Add tomatoes and broth. 3. Simmer and blend. 4. Season and serve.",
                10,
                30,
                "https://cdn.pixabay.com/photo/2016/06/01/21/40/soup-1429793_1280.jpg",
                Tomato, Onion, Garlic, Basil, OliveOil);
        Recipe lemon_herb_salmon = makeRecipe(
                "lemon_herb_salmon",
                "Lemon Herb Salmon",
                "1. Season salmon. 2. Place lemon slices on top. 3. Bake at 400°F. 4. Garnish with herbs.",
                10,
                15,
                "https://cdn.pixabay.com/photo/2016/06/28/17/32/salmon-1485014_1280.jpg",
                Salmon, Lemon, Dill, Garlic, OliveOil);
        Recipe chicken_curry = makeRecipe(
                "chicken_curry",
                "Chicken Curry",
                "1. Brown chicken. 2. Sauté onions and spices. 3. Add coconut milk and simmer. 4. Serve with rice.",
                15,
                30,
                "https://cdn.pixabay.com/photo/2016/03/05/19/02/curry-1238262_1280.jpg",
                Chicken_Breast, Onion, Coconut_Milk, Cumin, Ginger);
        Recipe caesar_salad = makeRecipe(
                "caesar_salad",
                "Caesar Salad",
                "1. Make dressing. 2. Toss lettuce with dressing. 3. Add croutons and cheese. 4. Garnish with chicken.",
                15,
                0,
                "https://cdn.pixabay.com/photo/2017/03/19/14/59/italian-salad-2156723_1280.jpg",
                Chicken_Breast, Cheese, Garlic, Lemon, OliveOil);
        Recipe vegetable_lasagna = makeRecipe(
                "vegetable_lasagna",
                "Vegetable Lasagna",
                "1. Prepare vegetables and sauce. 2. Layer pasta, vegetables, and cheese. 3. Bake at 375°F. 4. Let rest before serving.",
                30,
                45,
                "https://cdn.pixabay.com/photo/2017/02/15/15/17/meal-2069021_1280.jpg",
                Pasta, Tomato, Zucchini, Spinach, Cheese);
        Recipe beef_stir_fry = makeRecipe(
                "beef_stir_fry",
                "Beef Stir Fry",
                "1. Slice beef thinly. 2. Stir-fry beef in hot wok. 3. Add vegetables and sauce. 4. Serve over rice.",
                20,
                15,
                "https://cdn.pixabay.com/photo/2015/11/19/10/38/food-1050813_1280.jpg",
                Beef, Bell_Pepper, Broccoli, Soy_Sauce, Garlic);
        Recipe pesto_pasta = makeRecipe(
                "pesto_pasta",
                "Pesto Pasta",
                "1. Cook pasta. 2. Blend pesto ingredients. 3. Toss pasta with pesto. 4. Garnish with cheese.",
                10,
                15,
                "https://cdn.pixabay.com/photo/2016/11/23/18/31/pasta-1854245_1280.jpg",
                Pasta, Basil, Garlic, OliveOil, Cheese);
        Recipe roasted_vegetables = makeRecipe(
                "roasted_vegetables",
                "Roasted Vegetables",
                "1. Chop vegetables. 2. Toss with oil and herbs. 3. Roast at 425°F. 4. Season and serve.",
                15,
                30,
                "https://cdn.pixabay.com/photo/2016/09/15/19/24/salad-1672505_1280.jpg",
                Potato, Carrot, Bell_Pepper, OliveOil, Rosemary);
        Recipe lemon_garlic_shrimp = makeRecipe(
                "lemon_garlic_shrimp",
                "Lemon Garlic Shrimp",
                "1. Marinate shrimp. 2. Heat oil in pan. 3. Cook shrimp until pink. 4. Add lemon juice and serve.",
                10,
                10,
                "https://cdn.pixabay.com/photo/2015/04/08/13/13/food-712665_1280.jpg",
                Garlic, Lemon, OliveOil, Parsley, Butter);
        Recipe vegetable_soup = makeRecipe(
                "vegetable_soup",
                "Vegetable Soup",
                "1. Sauté vegetables. 2. Add broth and simmer. 3. Season with herbs. 4. Serve hot.",
                15,
                30,
                "https://cdn.pixabay.com/photo/2017/03/17/17/33/soup-2152237_1280.jpg",
                Carrot, Celery, Onion, Potato, Tomato);
        Recipe chicken_fajitas = makeRecipe(
                "chicken_fajitas",
                "Chicken Fajitas",
                "1. Slice chicken and vegetables. 2. Cook chicken. 3. Sauté vegetables. 4. Serve with tortillas.",
                20,
                15,
                "https://cdn.pixabay.com/photo/2016/08/23/08/53/tacos-1613795_1280.jpg",
                Chicken_Breast, Bell_Pepper, Onion, Cumin, Lime);
        Recipe spinach_quiche = makeRecipe(
                "spinach_quiche",
                "Spinach Quiche",
                "1. Prepare crust. 2. Sauté spinach. 3. Mix eggs and cheese. 4. Bake at 375°F.",
                20,
                45,
                "https://cdn.pixabay.com/photo/2017/01/11/11/33/cake-1971552_1280.jpg",
                Spinach, Eggs, Cheese, Milk, Flour);
        Recipe beef_stew = makeRecipe(
                "beef_stew",
                "Beef Stew",
                "1. Brown beef. 2. Add vegetables and broth. 3. Simmer until tender. 4. Season and serve.",
                30,
                120,
                "https://cdn.pixabay.com/photo/2017/03/17/17/33/potato-2152234_1280.jpg",
                Beef, Potato, Carrot, Onion, Celery);
        Recipe apple_pie = makeRecipe(
                "apple_pie",
                "Apple Pie",
                "1. Prepare crust. 2. Mix apple filling. 3. Assemble pie. 4. Bake at 425°F then 350°F.",
                30,
                60,
                "https://cdn.pixabay.com/photo/2016/06/07/00/21/apple-pie-1440987_1280.jpg",
                Flour, Butter, Sugar, Cinnamon, Nutmeg);
        Recipe garlic_mashed_potatoes = makeRecipe(
                "garlic_mashed_potatoes",
                "Garlic Mashed Potatoes",
                "1. Boil potatoes. 2. Roast garlic. 3. Mash potatoes with garlic, butter, and milk. 4. Season and serve.",
                15,
                30,
                "https://cdn.pixabay.com/photo/2017/03/17/17/33/potato-2152234_1280.jpg",
                Potato, Garlic, Butter, Milk, Salt);
        Recipe pasta = makeRecipe(
                "spaghetti_carbonara",
                "Spaghetti Carbonara",
                "1. Cook pasta. 2. Fry bacon. 3. Mix eggs, cheese, and pepper. 4. Combine all ingredients.",
                15,
                20,
                "https://cdn.pixabay.com/photo/2015/04/08/13/13/pasta-712664_1280.jpg",
                Pasta, Eggs, Cheese, Black_Pepper, OliveOil);
        Recipe salad = makeRecipe(
                "greek_salad",
                "Greek Salad",
                "1. Chop vegetables. 2. Mix olive oil, lemon juice, and oregano for dressing. 3. Combine and toss.",
                15,
                0,
                "https://cdn.pixabay.com/photo/2016/08/09/10/30/tomatoes-1580273_1280.jpg",
                Tomato, Cucumber, Onion, OliveOil, Lemon, Oregano);
        Recipe soup = makeRecipe(
                "tomato_basil_soup",
                "Tomato Basil Soup",
                "1. Sauté onions and garlic. 2. Add tomatoes and broth. 3. Simmer and blend. 4. Stir in basil.",
                10,
                30,
                "https://cdn.pixabay.com/photo/2016/06/01/21/40/soup-1429793_1280.jpg",
                Tomato, Onion, Garlic, Basil, OliveOil);
        Recipe stir_fry = makeRecipe(
                "vegetable_stir_fry",
                "Vegetable Stir Fry",
                "1. Chop vegetables. 2. Heat oil in wok. 3. Stir fry vegetables. 4. Add soy sauce and seasonings.",
                15,
                10,
                "https://cdn.pixabay.com/photo/2015/10/01/14/26/vegetables-967000_1280.jpg",
                Bell_Pepper, Broccoli, Carrot, Garlic, Soy_Sauce, Ginger);
        Recipe risotto = makeRecipe(
                "mushroom_risotto",
                "Mushroom Risotto",
                "1. Sauté mushrooms. 2. Cook rice gradually with broth. 3. Stir in cheese and butter.",
                10,
                30,
                "https://cdn.pixabay.com/photo/2020/03/30/10/18/risotto-4983664_1280.jpg",
                Rice, Mushroom, Onion, Butter, Cheese, Garlic);
        Recipe curry = makeRecipe(
                "vegetable_curry",
                "Vegetable Curry",
                "1. Sauté onions and spices. 2. Add vegetables and coconut milk. 3. Simmer until vegetables are tender.",
                15,
                25,
                "https://cdn.pixabay.com/photo/2016/03/05/19/02/indian-food-1238619_1280.jpg",
                Potato, Carrot, Cauliflower, Coconut_Milk, Cumin, Ginger);
        Recipe omelette = makeRecipe(
                "cheese_omelette",
                "Cheese Omelette",
                "1. Beat eggs. 2. Cook in pan. 3. Add cheese and fold. 4. Serve hot.",
                5,
                10,
                "https://cdn.pixabay.com/photo/2017/01/14/00/18/omelette-1978810_1280.jpg",
                Eggs, Cheese, Butter, Salt, Black_Pepper);
        Recipe smoothie = makeRecipe(
                "berry_smoothie",
                "Berry Smoothie",
                "1. Blend all ingredients until smooth. 2. Pour into glasses and serve.",
                5,
                0,
                "https://cdn.pixabay.com/photo/2018/09/23/09/31/smoothie-3697014_1280.jpg",
                Milk, Yogurt, Honey, Spinach);
        Recipe guacamole = makeRecipe(
                "classic_guacamole",
                "Classic Guacamole",
                "1. Mash avocados. 2. Mix in other ingredients. 3. Season to taste.",
                10,
                0,
                "https://cdn.pixabay.com/photo/2017/08/23/22/01/guacamole-2674830_1280.jpg",
                Avocado, Tomato, Onion, Cilantro, Lemon, Salt);
        Recipe pancakes = makeRecipe(
                "fluffy_pancakes",
                "Fluffy Pancakes",
                "1. Mix dry ingredients. 2. Add wet ingredients. 3. Cook on griddle until golden.",
                10,
                15,
                "https://cdn.pixabay.com/photo/2016/11/29/11/38/breakfast-1869132_1280.jpg",
                Flour, Eggs, Milk, Butter, Sugar);
        Recipe hummus = makeRecipe(
                "classic_hummus",
                "Classic Hummus",
                "1. Blend chickpeas and tahini. 2. Add other ingredients. 3. Process until smooth.",
                10,
                0,
                "https://cdn.pixabay.com/photo/2021/01/16/09/05/meal-5921491_1280.jpg",
                Garlic, Lemon, OliveOil, Cumin);
        Recipe coleslaw = makeRecipe(
                "creamy_coleslaw",
                "Creamy Coleslaw",
                "1. Shred vegetables. 2. Mix dressing. 3. Combine and chill.",
                15,
                60,
                "https://cdn.pixabay.com/photo/2016/08/11/08/49/coleslaw-1585340_1280.jpg",
                Carrot, Mayonnaise, Vinegar, Sugar, Salt);

        Recipe lemonade = makeRecipe(
                "fresh_lemonade",
                "Fresh Lemonade",
                "1. Juice lemons. 2. Mix with water and sugar. 3. Chill and serve over ice.",
                10,
                30,
                "https://cdn.pixabay.com/photo/2016/07/21/11/17/drink-1532300_1280.jpg",
                Lemon, Sugar, Water);
    }

    private Recipe makeRecipe(String dbName, String title, String cookingSteps, int prepTime, int cookTime,
                              String imageUrl, Ingredient ... ingredients) {
        Recipe recipe = new Recipe();
        recipe.setDbName(dbName);
        recipe.setTitle(title);
        recipe.setCookingSteps(cookingSteps);
        recipe.setCookTime(cookTime);
        recipe.setPrepTime(prepTime);
        recipe.setImageUrl(imageUrl);

        Set<Ingredient> recipeIngredients = new HashSet<>(Arrays.asList(ingredients));
        recipe.setIngredients(recipeIngredients);

        recipeRepository.save(recipe);
        return recipe;
    }

    private Ingredient makeIngredient(String name) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);

        ingredientRepository.save(ingredient);
        return ingredient;
    }

    private RecipeUser makeRecipeUser(String username, String password, String role) {
        RecipeUser user = new RecipeUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userService.save(user);
        return user;
    }
}
