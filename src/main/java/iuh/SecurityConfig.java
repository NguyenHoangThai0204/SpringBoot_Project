package iuh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/**").permitAll()
            )
            .formLogin(form -> form
                .loginPage("/signin")
                .loginProcessingUrl("/signin")
                .failureHandler(authenticationFailureHandler())
                .successHandler(authenticationSuccessHandler())
            )
            .logout(logout -> logout
                .permitAll()
            );
            
        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler("/signin?error");
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    
}
