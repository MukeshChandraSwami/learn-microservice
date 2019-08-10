package com.learn.bms.ms.learnbmsms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.bms.ms.learnbmsms.constants.FailResponseCode;
import com.learn.bms.ms.learnbmsms.constants.FailResponseMsg;
import com.learn.bms.ms.learnbmsms.constants.SuccessResponseCode;
import com.learn.bms.ms.learnbmsms.constants.SuccessResponseMsg;
import com.learn.bms.ms.learnbmsms.entity.BookEO;
import com.learn.bms.ms.learnbmsms.model.Book;
import com.learn.bms.ms.learnbmsms.repo.BookRepo;
import com.learn.bms.ms.learnbmsms.request.AddBookRequest;
import com.learn.bms.ms.learnbmsms.response.BookResponse;
import com.learn.bms.ms.learnbmsms.response.Response;
import com.learn.bms.ms.learnbmsms.utils.DateUtils;
import com.learn.bms.ms.learnbmsms.utils.OrikaGlobalMapper;

@Service
public class BookService {

	@Autowired
	BookRepo bookRepo;

	public Response getBookById(String id) {

		BookResponse response = new BookResponse();

		Optional<BookEO> bookEo = bookRepo.getBookById(id);
		if (bookEo.isPresent()) {
			response.setSuccess(true);
			response.setResponseCode(SuccessResponseCode.BOOK_FOUND);
			response.setResponseMsg(SuccessResponseMsg.BOOK_FOUND);

			Book b = new OrikaGlobalMapper<BookEO, Book>(bookEo.get(), Book.class).map();
			b.setPublished(DateUtils.convertMilisToString(bookEo.get().getPublishedOn(), "dd/MM/yyyy"));

			response.setBook(b);
		} else {
			response.setResponseCode(FailResponseCode.BOOK_NOT_FOUND);
			response.setResponseMsg(FailResponseMsg.BOOK_NOT_FOUND);
		}
		return response;
	}

	public Response addBook(AddBookRequest addBookRequest) {

		BookResponse response = new BookResponse();
		try {
			BookEO bookEo = new OrikaGlobalMapper<AddBookRequest, BookEO>(addBookRequest, BookEO.class).map();
			bookEo.setPublishedOn(DateUtils.convertStringToDate(addBookRequest.getPublished(), "dd/MM/yyyy").getTime());
			bookRepo.addBook(bookEo);

			response.setSuccess(true);
			response.setResponseCode(SuccessResponseCode.BOOK_ADDED);
			response.setResponseMsg(SuccessResponseMsg.BOOK_ADDED);

			Book b = new OrikaGlobalMapper<BookEO, Book>(bookEo, Book.class).map();
			b.setPublished(DateUtils.convertMilisToString(bookEo.getPublishedOn(), "dd/MM/yyyy"));

			response.setBook(b);
		} catch (Exception e) {
			response.setResponseCode(FailResponseCode.BOOK_NOT_ADDED);
			response.setResponseMsg(FailResponseMsg.BOOK_NOT_ADDED);
		}

		return response;
	}
}
