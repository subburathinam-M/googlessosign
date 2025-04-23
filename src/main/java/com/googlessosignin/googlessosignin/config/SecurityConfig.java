package com.googlessosignin.googlessosignin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    // @Autowired
    private CustomOAuth2SuccessHandler successHandler;


    public SecurityConfig(CustomOAuth2SuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login").permitAll()  // Allowing login page and homepage
                .anyRequest().authenticated()  // All other requests need authentication
            )
            .oauth2Login(oauth -> oauth
                .loginPage("/login")  // Custom login page URL
                .successHandler(successHandler)  // Redirect logic after successful login
            );
        return http.build();
    }

}
