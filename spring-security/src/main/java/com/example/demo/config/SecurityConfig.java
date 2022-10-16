package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication()
		.withUser("india")
		.password(encoder.encode("india"))
		.roles("ADMIN").and()
		.withUser("nepal")
		.password(encoder.encode("nepal"))
		.roles("GUEST");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		//allowed for authenticated users  - students,teachers(india,nepal)
//		http.authorizeHttpRequests()
//		.antMatchers("/api/v1/students/**")
//		.permitAll()
//		.and().authorizeRequests()
//			.antMatchers("/api/v1/teachers/**")
//			.authenticated()
//		.and().httpBasic();
		
		
		//teacher - allowed only for india ,not allowed for nepal
//		http.authorizeHttpRequests()
//		.antMatchers("/api/v1/students/**")
//		.permitAll()
//		.and().authorizeRequests()
//			.antMatchers("/api/v1/teachers/**")
//			.hasAnyRole("ADMIN")
//			.and().httpBasic();
		
		
		//teacher - allowed only for india ,not allowed for nepal
		//staff -allowed for both india and nepal
		http.authorizeHttpRequests()
		.antMatchers("/api/v1/students/**")
		.permitAll()
		.and().authorizeRequests()
			.antMatchers("/api/v1/teachers/**").hasAnyRole("ADMIN")
			.antMatchers("/api/v1/staff/**").hasAnyRole("ADMIN","GUEST")
			.and().httpBasic();
	}

	
	

}
