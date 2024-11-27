package nl.miwnn.se14.ares.recipeasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author armazadev
 *  Catch information regarding login
 */
public class RecipeUserDTO {

    @NotBlank (message = "Username cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 6)
    private String password;
    private String passwordConfirm;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
