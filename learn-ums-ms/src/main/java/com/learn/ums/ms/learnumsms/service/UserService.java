package com.learn.ums.ms.learnumsms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ums.ms.learnumsms.constants.FailResponseCode;
import com.learn.ums.ms.learnumsms.constants.FailResponseMsg;
import com.learn.ums.ms.learnumsms.constants.SuccessResponseCode;
import com.learn.ums.ms.learnumsms.constants.SuccessResponseMsg;
import com.learn.ums.ms.learnumsms.entity.UserEO;
import com.learn.ums.ms.learnumsms.model.User;
import com.learn.ums.ms.learnumsms.repo.UserRepo;
import com.learn.ums.ms.learnumsms.request.SignUpRequest;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.response.UserResponse;
import com.learn.ums.ms.learnumsms.utils.DateUtils;
import com.learn.ums.ms.learnumsms.utils.OrikaGlobalMapper;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public Response getUserById(String id) {

		UserResponse response = new UserResponse();
		
		Optional<UserEO> userEO = userRepo.getUserById(id);
		
		if(userEO.isPresent()) {
			OrikaGlobalMapper mapper = new OrikaGlobalMapper(userEO.get(), User.class);
			User user = (User) mapper.map();
			
			response.setSuccess(true);
			response.setResponseCode(SuccessResponseCode.USER_FOUND);
			response.setResponseMsg(SuccessResponseMsg.USER_FOUND);
			user.setDateOfBirth(DateUtils.convertMilisToString(userEO.get().getDob(), "dd/MM/yyyy"));
			response.setUser(user);
		}else {
			response.setResponseCode(FailResponseCode.USER_NOT_FOUND);
			response.setResponseMsg(FailResponseMsg.USER_NOT_FOUND);
		}
		
		return response;
	}

	public Response craeteUser(SignUpRequest signUpRequest) {
		UserResponse response = new UserResponse();

		try {
			OrikaGlobalMapper mapper = new OrikaGlobalMapper(signUpRequest, UserEO.class);
			UserEO userEo = (UserEO) mapper.map();
			userEo.setDob(DateUtils.convertStringToDate(signUpRequest.getDateOfBirth(), "dd/MM/yyyy").getTime());
			if (userEo != null) {
				userRepo.creatUser(userEo);
			}

			mapper = new OrikaGlobalMapper(userEo, User.class);
			User user = (User) mapper.map();
			user.setDateOfBirth(signUpRequest.getDateOfBirth());

			response.setSuccess(true);
			response.setResponseCode(SuccessResponseCode.SIGNED_UP);
			response.setResponseMsg(SuccessResponseMsg.SIGNED_UP);
			response.setUser(user);
		} catch (Exception e) {
			response.setResponseCode(FailResponseCode.SIGNED_UP);
			response.setResponseMsg(FailResponseMsg.SIGNED_UP);
		}

		return response;
	}

}
