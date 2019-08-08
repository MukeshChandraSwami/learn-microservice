package com.learn.ums.ms.learnumsms.model;

public class User {

	private String id;
	private String firstName;
	private String lastname;
	private String mob;
	private String email;
	private long dob;
	
	public User() {}
	
	public User(String id,String firstName, String lastname, String mob, String email, long dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.mob = mob;
		this.email = email;
		this.dob = dob;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
