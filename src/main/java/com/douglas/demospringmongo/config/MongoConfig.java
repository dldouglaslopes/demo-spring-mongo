package com.douglas.demospringmongo.config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Configuration
public class MongoConfig {
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	private CodecRegistry codecRegistry;
	private MongoCollection<Document> collection;
	
	public MongoCollection<Document> getCollection() {
		return collection;
	}

	public MongoConfig() {	
		this.codecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),fromProviders(PojoCodecProvider.builder().automatic(true).build())); //create a codec registry
		this.mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(codecRegistry).build()); //creating a Mongo client
		this.mongoDatabase = mongoClient.getDatabase("demo").withCodecRegistry(codecRegistry); //create a database
		this.collection = mongoDatabase.getCollection("demospringmongo").withCodecRegistry(codecRegistry); //create a collection
	}
	
	public void close() {
		mongoClient.close(); //close client
	}
}
