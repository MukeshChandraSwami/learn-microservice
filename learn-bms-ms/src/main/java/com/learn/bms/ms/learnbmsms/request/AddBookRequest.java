package com.learn.bms.ms.learnbmsms.request;

public class AddBookRequest extends BaseRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String autherId;
	private int totalPages;
	private float price;
	private String description;
	private String publication;
	private String published;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the autherId
	 */
	public String getAutherId() {
		return autherId;
	}
	/**
	 * @param autherId the autherId to set
	 */
	public void setAutherId(String autherId) {
		this.autherId = autherId;
	}
	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return totalPages;
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the publication
	 */
	public String getPublication() {
		return publication;
	}
	/**
	 * @param publication the publication to set
	 */
	public void setPublication(String publication) {
		this.publication = publication;
	}
	/**
	 * @return the published
	 */
	public String getPublished() {
		return published;
	}
	/**
	 * @param published the published to set
	 */
	public void setPublished(String published) {
		this.published = published;
	}
}
