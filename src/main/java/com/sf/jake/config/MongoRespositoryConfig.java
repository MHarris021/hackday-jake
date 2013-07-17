package com.sf.jake.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories
public class MongoRespositoryConfig extends AbstractMongoConfiguration{

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoRespositoryConfig.class); 
	
	@Value(value="${mongo.uri}")
	private String uri;
	
	@Override
	protected String getDatabaseName() {
		return "hackday-jake";
	}

	@Override
	public Mongo mongo() throws Exception {
		LOGGER.error("Mongo URI:" + uri);
			MongoClientURI mongoClientURI = new MongoClientURI(uri);
			
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		return mongoClient;
	}

}
