package com.learn.bms.ms.learnbmsms.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.bms.ms.learnbmsms.constants.Urls;
import com.learn.bms.ms.learnbmsms.request.AddBookRequest;
import com.learn.bms.ms.learnbmsms.response.Response;
import com.learn.bms.ms.learnbmsms.service.BookService;

@RestController
@RequestMapping("/" + Urls.BOOK)
public class BookingController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/{id}/"+Urls.GET)
	public Response getBookById(@PathParam(value = "id") String id ) {
		
		return bookService.getBookById(id);
	}
	
	@PostMapping("/" + Urls.ADD_BOOK)
	public Response addBook(@RequestBody AddBookRequest addBookRequest) {
		
		return bookService.addBook(addBookRequest);
	}
}
