package com.learn.ums.ms.learnumsms.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.ums.ms.learnumsms.request.LogInRequest;

public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) {
		LogInRequest loginReq = new LogInRequest();
		try {
			loginReq = new ObjectMapper().readValue(request.getInputStream(), LogInRequest.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(loginReq.getEmail(),loginReq.getPassword()));
	}
}
