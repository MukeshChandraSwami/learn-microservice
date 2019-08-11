package com.learn.ums.ms.learnumsms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.learn.ums.ms.learnumsms.constants.UrlEndPoint;
import com.learn.ums.ms.learnumsms.constants.UserRoles;

@Configuration
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity (securedEnabled = true)
public class UserWebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsServie;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void configure(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService(userDetailsServie).passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(HttpSecurity web) throws Exception {
		web
			.authorizeRequests()
				.antMatchers("/"+UrlEndPoint.USER + "/**").permitAll()
				.antMatchers("/"+UrlEndPoint.USER + "/" + UrlEndPoint.ADMIN + "/**").hasRole(UserRoles.ADMIN.getRole())
					.anyRequest().authenticated()
				.antMatchers("/"+UrlEndPoint.USER + "/" + UrlEndPoint.AUTHOR + "/**").hasRole(UserRoles.AUTHOR.getRole())
					.anyRequest().authenticated();
		
		web.csrf().disable();
	}
}
