package com.learn.api.gateway.bookapigateway.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.learn.api.gateway.bookapigateway.filter.AuthorizationFilter;

@Configuration
@EnableWebSecurity
public class GatewayWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment env;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, env.getProperty("path.user.login"),env.getProperty("path.user.signup")).permitAll()
			.anyRequest().authenticated();
		http.addFilter(new AuthorizationFilter(authenticationManager(), env));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
