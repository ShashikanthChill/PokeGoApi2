/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.configs;

import com.thehumblefool.pokégoapi2.services.AdminUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author TheHumbleFool
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AdminUserDetailsService userService;

    @Autowired
    public SecurityConfig(AdminUserDetailsService userService) {
        System.out.println("inited security");
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable();

        http
                .authorizeRequests().
                antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/", "/**").permitAll();

        http
                .formLogin()
                .permitAll()
                .and()
                .logout();

        http
                .httpBasic();
    }

}
