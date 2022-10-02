package com.demco.core

import io.ktor.server.sessions.*
import java.util.NoSuchElementException

class SessionStore : SessionStorage {
  override suspend fun invalidate(id: String) {
    RedisCache.remove(id)
  }

  override suspend fun write(id: String, value: String) {
    RedisCache.set(id, value)
  }

  override suspend fun read(id: String): String {
    return RedisCache.get(id) ?: throw NoSuchElementException("Session $id not found.")
  }
}