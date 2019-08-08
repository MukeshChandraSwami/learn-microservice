package com.learn.bms.ms.learnbmsms.model;

public class Book {

	private String bookId;
	private String name;
	private String autherId;
	private int totalPages;
	
	
	public Book(String bookId, String name, String autherId, int totalPages) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.autherId = autherId;
		this.totalPages = totalPages;
	}
	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
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
}
