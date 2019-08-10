package com.learn.bms.ms.learnbmsms.config;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {

	private MongoConfig() {}

	private static MongoConfig config = null;
	private static MongoDatabase mongoDb = null;

	public static MongoConfig getMongoInstance() {
		if (config == null) {
			config = new MongoConfig();
		}
		return config;
	}

	public MongoDatabase getMongoDatabase() {

		if(mongoDb == null) {
			CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
					CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	
			MongoClient client = new MongoClient("localhost", 27017);
			mongoDb = client.getDatabase("bms-ms").withCodecRegistry(pojoCodecRegistry);
		}
		return mongoDb;
	}
}