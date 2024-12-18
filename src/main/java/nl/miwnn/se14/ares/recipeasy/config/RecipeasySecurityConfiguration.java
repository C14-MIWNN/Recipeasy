package nl.miwnn.se14.ares.recipeasy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author armazadev
 * configure the security for my application
 */
@Configuration
@EnableWebSecurity
public class RecipeasySecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/recipe/overview", "/search", "/recipe/detail/{recipeName}").permitAll()
                        .requestMatchers("/user/register", "user/save").permitAll()
                        .requestMatchers("/webjars/**", "/css/**").permitAll()
                        .requestMatchers("/user/profile").permitAll()
                        .requestMatchers("/user/welcome").permitAll()
                        .requestMatchers("/user/profile").permitAll()
                        .requestMatchers("/user/welcome").permitAll()
                        .requestMatchers("/Food_pics/**").permitAll()
                        .requestMatchers("/recipe/delete/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout((logout) -> logout.logoutSuccessUrl("/").permitAll());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
