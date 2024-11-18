package nl.miwnn.se14.ares.recipeasy.service;

import nl.miwnn.se14.ares.recipeasy.dto.RecipeUserDTO;
import nl.miwnn.se14.ares.recipeasy.model.RecipeUser;
import nl.miwnn.se14.ares.recipeasy.repositories.RecipeUserRepository;
import nl.miwnn.se14.ares.recipeasy.service.mapper.RecipeUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author armazadev
 * Purpose
 */

@Service
public class RecipeUserService implements UserDetailsService {
    private final RecipeUserRepository recipeUserRepository;
    private final PasswordEncoder passwordEncoder;

    public RecipeUserService(RecipeUserRepository recipeUserRepository, PasswordEncoder passwordEncoder) {
        this.recipeUserRepository = recipeUserRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return recipeUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s was not found.", username)));
    }

    public boolean usernameInUse(String username) {
        return recipeUserRepository.findByUsername(username).isPresent();
    }

    public void save(RecipeUserDTO userDTO) {
        save(RecipeUserMapper.fromDTO(userDTO));
    }

    public void save(RecipeUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        recipeUserRepository.save(user);
    }

    public List<RecipeUser> getAllUsers() {
        return recipeUserRepository.findAll();
    }

}
