package data.database

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import data.util.Constants

object DatabaseFactory {
 fun createDatabase(): MongoDatabase {
  // Implementation for creating the database
     val connectionString = System.getenv("MONGO_URI") ?: throw IllegalArgumentException("MONGODB_URI  is not set")
     val dataBaseName = Constants.MONGO_DATABASE_NAME
     val mongoClient = MongoClient.create(connectionString)
     return mongoClient.getDatabase(dataBaseName)
 }

}