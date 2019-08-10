package com.learn.bms.ms.learnbmsms.entity;

public class BookEO extends BaseEO{

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
	private long publishedOn;
	
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
	 * @return the publishedOn
	 */
	public long getPublishedOn() {
		return publishedOn;
	}
	/**
	 * @param publishedOn the publishedOn to set
	 */
	public void setPublishedOn(long publishedOn) {
		this.publishedOn = publishedOn;
	}
}
