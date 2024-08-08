package com.thunderCoder.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.thunderCoder.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	MyUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
		.csrf(customizer -> customizer.disable()) //disabling csrf
		.authorizeHttpRequests(request -> request.anyRequest().authenticated()) //putting security for all request
		.httpBasic(Customizer.withDefaults()) // added for postman for rest api access
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build(); // for working with postman for stateless session
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		
		 * UserDetails user1 = User .withDefaultPasswordEncoder() // password without
		 * encryption .username("ankit") .password("ankit") .roles("USER") .build();
		 * 
		 * UserDetails user2 = User .withDefaultPasswordEncoder() // password without
		 * encryption .username("piyu") .password("piyu") .roles("ADMIN") .build();
		 * return new InMemoryUserDetailsManager(user1,user2);
		 // For hardcoding stuff
	} */
}
