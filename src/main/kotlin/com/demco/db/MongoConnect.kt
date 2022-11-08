package com.demco.db

import org.litote.kmongo.reactivestreams.KMongo

object MongoConnect {
  private val client = KMongo.createClient()
  private val database = client.getDatabase("person")
  suspend fun <T>collection(collection: String, clazz: Class<T>) {
  }
}