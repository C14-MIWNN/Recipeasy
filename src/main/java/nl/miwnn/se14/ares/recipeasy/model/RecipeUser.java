package nl.miwnn.se14.ares.recipeasy.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author armazadev
 * People able to login to see recipes and handle them
 */

@Entity
public class RecipeUser implements UserDetails {
    String ROLE_PREFIX = "ROLE_";

    @Id @GeneratedValue
    private Long userId;

    @Column(unique=true)
    private String username;
    private String password;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));

        return list;
    }

    @ManyToMany(mappedBy = "likedByUserSet", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //deleting user deletes all recipes
    private Set<Recipe> likedRecipes;

    @OneToMany(mappedBy = "recipeAuthor")
    private Set<Recipe> myRecipes;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
