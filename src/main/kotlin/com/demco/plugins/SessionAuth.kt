package com.demco.plugins

import com.demco.core.Response
import com.demco.core.SessionStore
import com.demco.rest.dto.UserResponseDTO
import com.demco.rest.dto.toResponseDTO
import com.demco.rest.entity.Users
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*
import io.ktor.util.*
import org.jetbrains.exposed.sql.transactions.transaction

data class UserSession(val user: UserResponseDTO): Principal

fun Application.configureAuth() {
  install(Authentication) {
    form("auth-form") {
      userParamName = "email"
      passwordParamName = "password"
      validate { credentials ->
        val user = transaction { Users.findByEmail(credentials.name) }

        if (credentials.password == user?.password) {
          UserSession(user.toResponseDTO())
        } else {
          null
        }
      }
      challenge {
        // TODO: need to do more than just respondText, exception or redirect to login
        throw AuthenticationException()
      }
    }
    session<UserSession>("auth-session") {
      validate { session ->
        session
      }
    }
  }
}

fun Application.configureSessions() {
  install(Sessions) {
    val secretEncryptKey = hex("00112233445566778899aabbccddeeff")
    val secretSignKey = hex("6819b57a326945c1968f45236589")
    cookie<UserSession>("user_session", SessionStore()) {
      cookie.path = "/"
      cookie.maxAge = null
      cookie.extensions["SameSite"] = "lax"
      cookie.httpOnly = true
      cookie.secure = false // TODO: this must be set to true before production deployment
      transform(SessionTransportTransformerEncrypt(secretEncryptKey, secretSignKey))
    }
  }
}



