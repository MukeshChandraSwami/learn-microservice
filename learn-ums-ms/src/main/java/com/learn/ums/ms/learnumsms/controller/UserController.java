package com.learn.ums.ms.learnumsms.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ums.ms.learnumsms.constants.UrlEndPoint;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.service.UserService;

@RestController
@RequestMapping("/" + UrlEndPoint.USER)
public class UserController {

	@Autowired
	private UserService userService;
	
	//@Secured("ROLE_USER")
	@GetMapping("/{id}/"+UrlEndPoint.GET)
	public Response getUserById(@PathParam(value = "id") String id ) {
		
		return userService.getUserById(id);
	}
	
	@GetMapping("/" + UrlEndPoint.GET + "/" + UrlEndPoint.BY_EMAIL)
	public Response getUserByEmail(@RequestParam(value = "email") String email ) {
		
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/"+UrlEndPoint.GET + "/" + UrlEndPoint.BY_MOB)
	public Response getUserByMobile(@RequestParam(value = "mob", required = true) String mob ) {
		
		return userService.getUserByMobile(mob);
	}
	
	@GetMapping("/" + UrlEndPoint.AUTHOR + "/" + UrlEndPoint.GET)
	public String getAuthorPractive() {
		
		return "author accessed.";
	}
	
	@GetMapping("/" + UrlEndPoint.STATUS)
	public String checkStatusOfUserService() {
		return userService.checkStatusOfUserService();
	}
}
