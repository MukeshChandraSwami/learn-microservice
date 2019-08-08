package com.learn.bms.ms.learnbmsms.service;

import org.springframework.stereotype.Service;

import com.learn.bms.ms.learnbmsms.constants.SuccessResponseCode;
import com.learn.bms.ms.learnbmsms.constants.SuccessResponseMsg;
import com.learn.bms.ms.learnbmsms.model.Book;
import com.learn.bms.ms.learnbmsms.response.BookResponse;
import com.learn.bms.ms.learnbmsms.response.Response;

@Service
public class BookService {

	public Response getUserById(String id) {
		
		BookResponse response = new BookResponse();
		response.setSuccess(true);
		response.setResponseCode(SuccessResponseCode.BOOK_FOUND);
		response.setResponseMsg(SuccessResponseMsg.BOOK_FOUND);
		response.setBook(new Book(id, "Java-1.8", "auth-java-01", 1000));
		return response;
	}

	
}
