package com.learn.ums.ms.learnumsms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.ums.ms.learnumsms.constants.FailResponseCode;
import com.learn.ums.ms.learnumsms.constants.FailResponseMsg;
import com.learn.ums.ms.learnumsms.constants.SuccessResponseCode;
import com.learn.ums.ms.learnumsms.constants.SuccessResponseMsg;
import com.learn.ums.ms.learnumsms.entity.UserEO;
import com.learn.ums.ms.learnumsms.model.User;
import com.learn.ums.ms.learnumsms.repo.UserRepo;
import com.learn.ums.ms.learnumsms.request.LogInRequest;
import com.learn.ums.ms.learnumsms.request.SignUpRequest;
import com.learn.ums.ms.learnumsms.response.Response;
import com.learn.ums.ms.learnumsms.response.UserResponse;
import com.learn.ums.ms.learnumsms.service.impl.UserDetailsImpl;
import com.learn.ums.ms.learnumsms.utils.DateUtils;
import com.learn.ums.ms.learnumsms.utils.OrikaGlobalMapper;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private Environment env;

	public Response getUserById(String id) {

		Optional<UserEO> userEO = userRepo.getUserById(id);
		return getUserResponse(userEO);
	}

	public Response getUserByEmail(String email) {
		Optional<UserEO> userEO = userRepo.getUserByEmail(email);
		return getUserResponse(userEO);
	}

	public Response getUserByMobile(String mob) {
		Optional<UserEO> userEO = userRepo.getUserByMobile(mob);
		return getUserResponse(userEO);
	}

	public Response craeteUser(SignUpRequest signUpRequest) {
		UserResponse response = new UserResponse();

		try {
			OrikaGlobalMapper mapper = new OrikaGlobalMapper(signUpRequest, UserEO.class);
			UserEO userEo = (UserEO) mapper.map();
			userEo.setDob(DateUtils.convertStringToDate(signUpRequest.getDateOfBirth(), "dd/MM/yyyy").getTime());
			if (userEo != null) {
				userEo.setPassword(passEncoder.encode(signUpRequest.getPassword()));
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

	public Response logIn(LogInRequest logInRequest) {

		Response response = new UserResponse();
		
		Optional<UserEO> opUserEo = Optional.empty();
		if(logInRequest.getEmail() != null && !logInRequest.getEmail().isEmpty()) {
			opUserEo = userRepo.getUserByEmail(logInRequest.getEmail());
		}else {
			opUserEo = userRepo.getUserByMobile(logInRequest.getMob());
		}
		
		if(opUserEo.isPresent()) {
			
			UserEO userEO = opUserEo.get();
			boolean success = passEncoder.matches(logInRequest.getPassword(), userEO.getPassword());
			
			if(success) {
				response = getUserResponse(opUserEo);
				response.setResponseCode(SuccessResponseCode.LOGIN_SUCCESS);
				response.setResponseMsg(SuccessResponseMsg.LOGIN_SUCCESS);
			}else {
				response.setResponseCode(FailResponseCode.LOGIN_FAIL);
				response.setResponseMsg(FailResponseMsg.LOGIN_SUCCESS);
			}
		}
		
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return new UserDetailsImpl(userRepo.getUserByEmail(username).get());
	}

	private Response getUserResponse(Optional<UserEO> opUserEO) {

		UserResponse response = new UserResponse();

		if (opUserEO.isPresent()) {
			OrikaGlobalMapper<UserEO, User> mapper = new OrikaGlobalMapper<>(opUserEO.get(), User.class);
			User user = mapper.map();

			response.setSuccess(true);
			response.setResponseCode(SuccessResponseCode.USER_FOUND);
			response.setResponseMsg(SuccessResponseMsg.USER_FOUND);
			user.setDateOfBirth(DateUtils.convertMilisToString(opUserEO.get().getDob(), "dd/MM/yyyy"));
			response.setUser(user);
		} else {
			response.setResponseCode(FailResponseCode.USER_NOT_FOUND);
			response.setResponseMsg(FailResponseMsg.USER_NOT_FOUND);
		}

		return response;
	}

	public String checkStatusOfUserService() {
		return "Running : " + env.getProperty("server.port");
	}
}
