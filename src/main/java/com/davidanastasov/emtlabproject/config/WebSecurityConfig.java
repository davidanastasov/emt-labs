package com.davidanastasov.emtlabproject.config;

import com.davidanastasov.emtlabproject.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/books")
                .hasAnyRole(Role.ADMIN.getAuthority(), Role.LIBRARIAN.getAuthority())
                .requestMatchers(HttpMethod.GET)
                .permitAll()
                .anyRequest().hasRole(Role.ADMIN.getAuthority())
            )
            .formLogin((form) -> form
//                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login?error=BadCredentials")
                    .defaultSuccessUrl("/api/books", true)
            )
            .logout((logout) -> logout
                    .logoutUrl("/logout")
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login")
            )
            .exceptionHandling((ex) -> ex
                    .accessDeniedPage("/access_denied")
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .roles(Role.ADMIN.getAuthority())
                .build();
        UserDetails librarian = User.builder()
                .username("librarian")
                .password(passwordEncoder.encode("password"))
                .roles(Role.LIBRARIAN.getAuthority())
                .build();

        return new InMemoryUserDetailsManager(admin, librarian);
    }
}
