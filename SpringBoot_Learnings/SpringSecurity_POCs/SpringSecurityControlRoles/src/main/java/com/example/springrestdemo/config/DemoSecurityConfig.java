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

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Only admins can access
                        .requestMatchers("/manager/**").hasRole("MANAGER") // Only managers can access
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.defaultSuccessUrl("/", true))
                .logout(logout -> logout
                        .logoutUrl("/logout") // Ensures logout URL is correctly handled
                        .logoutSuccessUrl("/") // Redirects to home page after logout
                        .invalidateHttpSession(true) // Invalidates session on logout
                        .deleteCookies("JSESSIONID") // Deletes session cookies
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/access-denied") // Redirect to custom page for unauthorized access
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/logout") // Disable CSRF protection for logout URL only
                ); // New way to disable CSRF for specific URLs in Spring Security 6.1+

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
