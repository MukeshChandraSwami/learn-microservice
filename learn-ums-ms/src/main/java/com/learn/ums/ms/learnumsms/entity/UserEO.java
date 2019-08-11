package com.learn.ums.ms.learnumsms.entity;

import java.util.Set;

import com.learn.ums.ms.learnumsms.constants.UserRoles;

public class UserEO extends BaseEO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastname;
	private String mob;
	private String password;
	private String email;
	private long dob;
	private Set<UserRoles> roles;
	private boolean locked;
	private boolean expired;
	private boolean disabled;

	
	/**
	 * @return the roles
	 */
	public Set<UserRoles> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<UserRoles> roles) {
		this.roles = roles;
	}
	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}
	/**
	 * @param expired the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}
	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the mob
	 */
	public String getMob() {
		return mob;
	}
	/**
	 * @param mob the mob to set
	 */
	public void setMob(String mob) {
		this.mob = mob;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dob
	 */
	public long getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(long dob) {
		this.dob = dob;
	}
}
