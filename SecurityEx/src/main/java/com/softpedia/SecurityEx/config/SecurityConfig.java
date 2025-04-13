package com.softpedia.SecurityEx.config;

import jdk.jfr.Frequency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(configurer -> configurer.disable()) //disable csrf
                .authorizeHttpRequests(
                request -> request.anyRequest().authenticated()) //any request should be authenticated
                //.formLogin(Customizer.withDefaults()) //for the browser form login stick with the built-in form
                .httpBasic(Customizer.withDefaults())  //for the rest api client stick with the default also
                .sessionManagement(session ->
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails mohamed = User
                .withDefaultPasswordEncoder()
                .username("mohamed")
                .password("123*654")
                .roles("ADMIN")
                .build();

        UserDetails mona = User
                .withDefaultPasswordEncoder()
                .username("mona")
                .password("123*654")
                .roles("EMP")
                .build();

        return new InMemoryUserDetailsManager(mohamed,mona);
    }

}
