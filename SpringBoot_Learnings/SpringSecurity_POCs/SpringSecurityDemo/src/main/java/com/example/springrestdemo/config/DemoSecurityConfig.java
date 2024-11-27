package com.example.springrestdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class DemoSecurityConfig {

    // Define PasswordEncoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll() // Allow home page without authentication
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Example for restricting specific routes
                        .anyRequest().authenticated() // Require authentication for other routes
                )
                .formLogin(form -> form.defaultSuccessUrl("/", true)) // Enable form-based login
                .logout(logout -> logout.logoutSuccessUrl("/")); // Define logout behavior

        return http.build();
    }


    // Configure in-memory authentication
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authBuilder
                .inMemoryAuthentication()
                .withUser(User.builder()
                        .username("benny")
                        .password(passwordEncoder.encode("test123"))
                        .roles("EMPLOYEE"))
                .withUser(User.builder()
                        .username("sushma")
                        .password(passwordEncoder.encode("test123"))
                        .roles("MANAGER"))
                .withUser(User.builder()
                        .username("chan")
                        .password(passwordEncoder.encode("test123"))
                        .roles("ADMIN"));

        return authBuilder.build();
    }
}
