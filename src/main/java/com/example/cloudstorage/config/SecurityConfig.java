package com.example.cloudstorage.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login").permitAll().and()
                .logout().permitAll().and()
            .antMatcher("/**")
            .authorizeRequests()
                .antMatchers("/public").permitAll()
                //...
                .anyRequest()
                .authenticated();
    }
}
