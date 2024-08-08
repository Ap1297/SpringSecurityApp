package com.thunderCoder.model.config;

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
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
		.csrf(customizer -> customizer.disable()) //disabling csrf
		.authorizeHttpRequests(request -> request.anyRequest().authenticated()) //putting security for all request
		.httpBasic(Customizer.withDefaults()) // added for postman for rest api access
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build(); // for working with postman for stateless session
		
		
	}
}
