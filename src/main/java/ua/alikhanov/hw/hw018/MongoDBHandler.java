package ua.alikhanov.hw.hw018;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBHandler {
    private static final String CONNECTION_STRING = "mongodb://admin:admin123@localhost:27017";
    private static final String DATABASE_NAME = "testdb";
    private static final String PERSON_NAME = "Dzhavi Alikhanov";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("people");

            Document document = new Document("name", PERSON_NAME).append("age", 28);
            collection.insertOne(document);

            Document readDocument = collection.find(new Document("name", PERSON_NAME)).first();
            System.out.println("Read Document: " + readDocument);

            collection.updateOne(new Document("name", PERSON_NAME), new Document("$set", new Document("age", 28)));

            collection.deleteOne(new Document("name", PERSON_NAME));
        }
    }
}
