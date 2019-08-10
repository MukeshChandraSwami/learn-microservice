package com.learn.bms.ms.learnbmsms.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learn.bms.ms.learnbmsms.config.MongoConfig;
import com.learn.bms.ms.learnbmsms.constants.DBCollectionConsts;
import com.learn.bms.ms.learnbmsms.constants.DBQueryAttributes;
import com.learn.bms.ms.learnbmsms.entity.BookEO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Repository
public class BookRepo {

	public Optional<BookEO> getBookById(String id) {
		MongoDatabase mongoDb = MongoConfig.getMongoInstance().getMongoDatabase();
		MongoCollection<BookEO> col = mongoDb.getCollection(DBCollectionConsts.BOOK.getCollection()).withDocumentClass(BookEO.class);
		BookEO bookEO = col.find(Filters.eq(DBQueryAttributes.ID.getParam(), id)).first();
		
		if(bookEO != null) {
			return Optional.of(bookEO);
		}
		return Optional.empty();
	}

	public void addBook(BookEO bookEO) {
		
		List<BookEO> books = new ArrayList<>();
		books.add(bookEO);
		addBooks(books);
	}
	
	public void addBooks(List<BookEO> books) {
		MongoDatabase mongoDb = MongoConfig.getMongoInstance().getMongoDatabase();
		MongoCollection<BookEO> col = mongoDb.getCollection(DBCollectionConsts.BOOK.getCollection()).withDocumentClass(BookEO.class);
		col.insertMany(books);
	}
}
