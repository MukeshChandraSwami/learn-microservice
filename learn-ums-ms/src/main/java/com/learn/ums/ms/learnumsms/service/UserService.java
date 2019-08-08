package com.learn.ums.ms.learnumsms.service;

import org.springframework.stereotype.Service;

import com.learn.ums.ms.learnumsms.constants.SuccessResponseCode;
import com.learn.ums.ms.learnumsms.constants.SuccessResponseMsg;
import com.learn.ums.ms.learnumsms.model.User;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.response.UserResponse;

@Service
public class UserService {

	public Response getUserById(String id) {
		
		UserResponse response = new UserResponse();
		response.setSuccess(true);
		response.setResponseCode(SuccessResponseCode.USER_FOUND);
		response.setResponseMsg(SuccessResponseMsg.USER_FOUND);
		response.setUser(new User(id,"Mukesh", "Swami", "8766602057", "ms@gmail.com", 10999288838L));
		return response;
	}

	
}
