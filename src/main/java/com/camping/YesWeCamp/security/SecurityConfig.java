/*package com.camping.YesWeCamp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http) throws Exception {

		
		http.csrf().disable();
		//http.httpBasic().and().authorizeRequests()
		/*.antMatchers("/surveys/**").hasRole("USER") // anything has role of user let him go throught surveys
		.antMatchers("/users/**").hasRole("USER")  // anything has role of user let him go throught users
		.antMatchers("/**").hasRole("ADMIN")*/
		/*.and().csrf().disable()   /* hl browser setting this line and nexxt one */
	//	.headers().frameOptions().disable();*/
		/*.anyRequest().authenticated()
		.and().formLogin().and();
	}

}*/
