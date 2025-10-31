package com.proyecto.backend.app.backend_app.auth;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeRequests()
        .requestMatchers(HttpMethod.POST,"/usuarios").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf(config -> config
            .disable())
        .sessionManagement(management -> management
            .sessionCreationPolicy(SessionCreationPolicy
            .STATELESS))
        .build();
    }

}
