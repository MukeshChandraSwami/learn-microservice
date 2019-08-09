package com.learn.ums.ms.learnumsms.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.learn.ums.ms.learnumsms.config.MongoConfig;
import com.learn.ums.ms.learnumsms.constants.DBCollectionConsts;
import com.learn.ums.ms.learnumsms.constants.DBQueryAttributes;
import com.learn.ums.ms.learnumsms.entity.UserEO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@Repository
public class UserRepo {

	public void createUsers(List<UserEO> users) {
		MongoDatabase mongoDb = MongoConfig.getMongoInstance().getMongoDatabase();
		MongoCollection col = mongoDb.getCollection(DBCollectionConsts.USER.getCollection()).withDocumentClass(UserEO.class);
		col.insertMany(users);
	}
	
	public void creatUser(UserEO userEo) {
		
		List<UserEO> users = new ArrayList<>();
		users.add(userEo);
		createUsers(users);
	}

	public Optional<UserEO> getUserById(String id) {
		
		MongoDatabase mongoDb = MongoConfig.getMongoInstance().getMongoDatabase();
		MongoCollection col = mongoDb.getCollection(DBCollectionConsts.USER.getCollection()).withDocumentClass(UserEO.class);
		UserEO userEo = (UserEO)col.find(Filters.eq(DBQueryAttributes.ID.getParam(),id)).first();
		
		if(userEo != null) {
			return Optional.of(userEo);
		}
		
		return Optional.empty();
	}
}

