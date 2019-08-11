package com.learn.ums.ms.learnumsms.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ums.ms.learnumsms.constants.UrlEndPoint;
import com.learn.ums.ms.learnumsms.request.LogInRequest;
import com.learn.ums.ms.learnumsms.request.SignUpRequest;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.response.UserResponse;
import com.learn.ums.ms.learnumsms.service.UserService;
import com.learn.ums.ms.learnumsms.utils.DateUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/" + UrlEndPoint.USER)
public class LoginAndSignUpController {

	@Autowired
	private UserService userService;
	
	@Autowired
	Environment env;
	
	@PostMapping("/" + UrlEndPoint.SIGN_UP)
	public Response signUp(@RequestBody SignUpRequest signUpRequest) {
		
		return userService.craeteUser(signUpRequest);
	}
	
	@PostMapping("/" + UrlEndPoint.LOG_IN)
	public Response logIn(@RequestBody LogInRequest logInRequest, HttpServletResponse httpResponse) {
		
		Response response = userService.logIn(logInRequest);
		
		if(response.isSuccess()) {
			UserResponse userResponse = (UserResponse)response;
			String jwtToken = Jwts.builder()
					.setSubject(userResponse.getUser().getId())
					.setExpiration(DateUtils.addInDate(new Date(), Calendar.MINUTE, 3))
					.signWith(SignatureAlgorithm.HS512, env.getProperty("jwt.token.secret"))
					.compact();
			httpResponse.addHeader("token", jwtToken);
			httpResponse.addHeader("userId", userResponse.getUser().getId());
		}
		
		return response;
	}
	
}
