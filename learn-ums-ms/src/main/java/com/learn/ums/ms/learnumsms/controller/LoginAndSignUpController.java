package com.learn.ums.ms.learnumsms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ums.ms.learnumsms.constants.UrlEndPoint;
import com.learn.ums.ms.learnumsms.request.LogInRequest;
import com.learn.ums.ms.learnumsms.request.SignUpRequest;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.service.UserService;

@RestController
@RequestMapping("/" + UrlEndPoint.USER)
public class LoginAndSignUpController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/" + UrlEndPoint.SIGN_UP)
	public Response signUp(@RequestBody SignUpRequest signUpRequest) {
		
		return userService.craeteUser(signUpRequest);
	}
	
	@PostMapping("/" + UrlEndPoint.LOG_IN)
	public Response logIn(@RequestBody LogInRequest logInRequest) {
		
		return userService.logIn(logInRequest);
	}
	
}
