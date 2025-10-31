package com.loginpagewithsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
	private final UserDetailsService userDetailsService;
	
	
	
public SpringSecurity(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//		.authorizeHttpRequests(auth->auth
//				.requestMatchers("/public/**").permitAll()
//				.requestMatchers("/admin/**").authenticated()
//				
//				)
//		.formLogin(Customizer.withDefaults());
//		return httpSecurity.build();
//	}
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//		httpSecurity
//		.authorizeHttpRequests(request->request
//				.requestMatchers("register","login").permitAll()
//				.anyRequest().authenticated())
//		.httpBasic(Customizer.withDefaults());
//		return httpSecurity.build();
//	}
	   @Bean
       public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
           httpSecurity
               .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity in some cases
               .authorizeHttpRequests(authz -> authz
                   .requestMatchers("/public/**").permitAll() // Allow public access to certain paths
                   .anyRequest().authenticated() // All other requests require authentication
               )
               .httpBasic(Customizer.withDefaults()); // Enable HTTP Basic authentication

           return httpSecurity.build();
       }
	   
	  
	   
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails Piyush=User.withUsername("Piyush")
//				.password("{noop}pk")
//				.roles("USER")
//				.build();
//		
//		UserDetails ayush=User.withUsername("Ayush")
//				.password("{noop}AK")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(Piyush,ayush);
//		
//	}
	
//	public UserDetailsService userDetailsService() {
//		UserDetails ayush=User.withUsername("ayush")
//				.password("ak")
//				.roles("USER")
//				.build();
//		
//		return new InMemoryUserDetailsManager(ayush);
//	}
	   @Bean
	   public BCryptPasswordEncoder bCryptPasswordEncoder() {
		   return new BCryptPasswordEncoder();
	   }
	   
	   @Bean
	   public AuthenticationProvider authenticationProvider() {
		   DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider(userDetailsService);
//		   daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		   daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
		   return daoAuthenticationProvider;
	   }
	   
	   @Bean
	   public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)throws Exception{
		   return authenticationConfiguration.getAuthenticationManager();
	   }
	
	

}
