package com.zique.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityAdapter extends WebSecurityConfigurerAdapter {

	/**
	 * Overriding in order to enable frontend calls to resources
	 * to be completed.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()//disabled because I'll be using a JWT token
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()//allows all preflight OPTIONS requests
		.anyRequest().authenticated()//permitted requests as long as authenticated
		.and().httpBasic();//permite requests using Basic Auth
		super.configure(http);
	}

}
