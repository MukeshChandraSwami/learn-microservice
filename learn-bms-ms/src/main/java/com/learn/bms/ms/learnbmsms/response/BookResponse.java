package com.learn.bms.ms.learnbmsms.response;

import com.learn.bms.ms.learnbmsms.model.Book;
public class BookResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Book book;

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
}
