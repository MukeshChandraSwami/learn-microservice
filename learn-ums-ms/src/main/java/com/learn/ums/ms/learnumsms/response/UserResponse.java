package com.learn.ums.ms.learnumsms.response;

import com.learn.ums.ms.learnumsms.model.User;

public class UserResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
