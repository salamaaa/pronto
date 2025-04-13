package com.softpedia.SecurityEx.config;

import jdk.jfr.Frequency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(configurer -> configurer.disable()) //disable csrf
                .authorizeHttpRequests(
                request -> request.anyRequest().authenticated()) //any request should be authenticated
                //.formLogin(Customizer.withDefaults()) //for the browser form login stick with the built-in form
                .httpBasic(Customizer.withDefaults())  //for the rest api client stick with the default also
                .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }

}
