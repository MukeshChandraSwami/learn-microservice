package com.learn.ums.ms.learnumsms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.learn.ums.ms.learnumsms.constants.UrlEndPoint;

@Configurable
@EnableWebSecurity
public class UserWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment env;
	
	@Override
	public void configure(HttpSecurity web) throws Exception {
		web.authorizeRequests().antMatchers("/"+UrlEndPoint.USER + "/**").permitAll();
		web.csrf().disable();
	}
}
