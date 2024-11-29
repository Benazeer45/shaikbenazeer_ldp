package com.example.springrestdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()  // Allow access to login page
                        .requestMatchers("/").permitAll()       // Allow access to home page
                        .anyRequest().authenticated()            // Require authentication for other requests
                )
                .formLogin(form -> form
                        .loginPage("/login")                     // Custom login page
                        .defaultSuccessUrl("/", false)           // Redirect to home after successful login
                        .failureUrl("/login?error=true")         // Redirect on failure
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("benny").password(passwordEncoder().encode("test123")).roles("EMPLOYEE").build());
        manager.createUser(User.withUsername("sushma").password(passwordEncoder().encode("test123")).roles("MANAGER").build());
        manager.createUser(User.withUsername("chan").password(passwordEncoder().encode("test123")).roles("ADMIN").build());
        return manager;
    }
}