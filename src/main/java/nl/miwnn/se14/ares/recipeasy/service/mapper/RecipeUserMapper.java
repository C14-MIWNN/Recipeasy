package nl.miwnn.se14.ares.recipeasy.service.mapper;

import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;

/**
 * @author armazadev
 * Converts between Model classes and DTOs
 */
public class RecipeUserMapper {

    public static RecipeUser fromDTO(RecipeUserDTO dto) {
            RecipeUser user = new RecipeUser();
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            return user;
    }
    public static RecipeUserDTO toDTO(RecipeUser user) {
        RecipeUserDTO dto = new RecipeUserDTO();
        dto.setUsername(user.getUsername());
        return dto;
    }

}
