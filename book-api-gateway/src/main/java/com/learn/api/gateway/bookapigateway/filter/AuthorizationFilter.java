package com.learn.api.gateway.bookapigateway.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	private Environment env;

	public AuthorizationFilter(AuthenticationManager authenticationManager, Environment env) {
		super(authenticationManager);
		this.env = env;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String jwtToken = request.getHeader(env.getProperty("jwt.auth.token.name"));

		if (jwtToken == null || jwtToken.isEmpty()) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken authenticate(HttpServletRequest request) {

		String jwtToken = request.getHeader(env.getProperty("jwt.auth.token.name"));
		String userId = Jwts.parser().setSigningKey(env.getProperty("jwt.token.secret")).parseClaimsJws(jwtToken)
				.getBody().getSubject();

		if(userId == null || userId.isEmpty()) {	
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
	}

}
