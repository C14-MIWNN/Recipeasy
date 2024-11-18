package nl.miwnn.se14.ares.recipeasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author armazadev
 *  Catch information regarding login
 */
public class RecipeUserDTO {

        @NotBlank
        private String username;

        @Size(min = 6)
        private String password;
        private String passwordConfirm;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPasswordConfirm() {
            return passwordConfirm;
        }

        public void setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
        }

}
