package com.learn.ums.ms.learnumsms.constants;

public enum UserRoles {

	ADMIN ("ADMIN"), USER ("USER"), GUEST ("GUEST"), AUTHOR ("AUTHOR");
	
	private String role;

	UserRoles(String role){
		this.role = role;
	}
	public String getRole() {
		
		return this.role;
	}
}
