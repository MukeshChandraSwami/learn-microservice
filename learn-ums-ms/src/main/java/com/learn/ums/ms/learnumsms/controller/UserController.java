package com.learn.ums.ms.learnumsms.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ums.ms.learnumsms.constants.Urls;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.service.UserService;

@RestController
@RequestMapping("/" + Urls.USER)
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}/"+Urls.GET)
	public Response getUserById(@PathParam(value = "id") String id ) {
		
		return userService.getUserById(id);
	}
}
