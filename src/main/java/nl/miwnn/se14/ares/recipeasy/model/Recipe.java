package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * @author Johannes
 * Making recipes
 */
@Entity
public class Recipe {

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
