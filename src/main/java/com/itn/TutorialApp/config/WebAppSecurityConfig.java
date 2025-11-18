package com.itn.TutorialApp.config;

import com.itn.TutorialApp.service.AdminDetailService;
import com.itn.TutorialApp.service.MyUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebAppSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final MyUserDetailService myUserDetailService;
    private final AdminDetailService adminDetailService;

    // SecurityFilterChain configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(userAuthenticationProvider())
                .authenticationProvider(adminAuthenticationProvider())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/tutor/**").hasRole("TUTOR")
                        .requestMatchers("/user/**").hasRole("USER")
                        .anyRequest().permitAll()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/welcome", true)
                        .failureUrl("/login?failed")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .rememberMe(me -> me
                        .key("my_key")
                        .userDetailsService(myUserDetailService) // ✅ must provide UserDetailsService
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // User AuthenticationProvider
    @Bean
    public AuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // Admin AuthenticationProvider
    @Bean
    public AuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(adminDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // Optional in-memory admin
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("$2a$10$cWnl6LTOmd/KWa97YDXbV.MPc8MlQocIg4q2pCacbJ7hlpAZ8gJFq")
                        .roles("ADMIN")
                        .build()
        );
    }

    // Expose AuthenticationManager if needed elsewhere
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}