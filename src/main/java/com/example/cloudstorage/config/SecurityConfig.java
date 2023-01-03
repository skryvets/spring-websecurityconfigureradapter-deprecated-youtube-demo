package com.example.cloudstorage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .formLogin()
            .disable()
            .headers().disable()
            .csrf().disable()
            .antMatcher("/**")
            .authorizeRequests()
                .antMatchers("/public").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                //...
                .anyRequest()
                .authenticated();
        return http.build();
    }
}
