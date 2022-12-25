package com.example.cloudstorage.config;

import javax.sql.DataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Http security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .and()
            .antMatcher("/**")
                .authorizeRequests()
                    .anyRequest()
                    .authenticated();
    }

    // Web security
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/public")
            .antMatchers("/h2-console/**");
    }


    //JDBC Authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("Gregory")
            .password("password")
            .roles("USER")
            .build();
        auth.jdbcAuthentication()
            .withDefaultSchema()
            .dataSource(dataSource)
            .withUser(user);
    }
}
