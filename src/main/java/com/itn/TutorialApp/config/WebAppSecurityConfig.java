package com.itn.TutorialApp.config;

import com.itn.TutorialApp.service.AdminDetailService;
import com.itn.TutorialApp.service.CombinedUserDetailService;
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
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebAppSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final MyUserDetailService myUserDetailService;
    private final AdminDetailService adminDetailService;
    private final CombinedUserDetailService combinedUserDetailService;

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
                        .userDetailsService(combinedUserDetailService) // ✅ use combined service here
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public AuthenticationProvider userAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public AuthenticationProvider adminAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(adminDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // OPTIONAL in-memory admin for testing only
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("admin")
//                        .password("$2a$10$cWnl6LTOmd/KWa97YDXbV.MPc8MlQocIg4q2pCacbJ7hlpAZ8gJFq")
//                        .roles("ADMIN")
//                        .build()
//        );
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}