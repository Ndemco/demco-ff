package com.demco.core

import io.github.crackthecodeabhi.kreds.connection.Endpoint
import io.github.crackthecodeabhi.kreds.connection.newClient

// TODO: Maybe return byte array instead of String
object RedisCache {

  // TODO: this should be an env var
  val REDIS_URI = "redis:6379"

  suspend fun set(key: String, value: String) {
    newClient(Endpoint.from(REDIS_URI)).use { client ->
      client.set(key, value)
      client.expire(key, 600u) // set expiration to 600 seconds
    }
  }

  suspend fun get(key: String): String? {
    newClient(Endpoint.from(REDIS_URI)).use { client ->
      return client.get(key)
    }
  }

  suspend fun remove(key: String): Long {
    newClient(Endpoint.from(REDIS_URI)).use { client ->
      return client.del(key)
    }
  }
}