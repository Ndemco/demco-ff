package com.demco.rest.route

import com.demco.core.Response
import com.demco.core.respond
import com.demco.plugins.UserSession
import com.demco.rest.dto.UserRequestDTO
import com.demco.rest.service.UserService
import com.demco.util.getIntId
import io.ktor.server.application.call
import io.ktor.server.auth.*
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import io.ktor.server.routing.get
import io.ktor.server.routing.delete
import io.ktor.server.sessions.*

fun Route.userRoutes() = route("/users") {
  signup()
  authenticate("auth-form") { login() }
  authenticate("auth-session") {
    getAllUsers()
    getUserById()
    deleteUser()
  }
}

private fun Route.signup() = post<UserRequestDTO>("/signup") { body ->
  call.respond(UserService.signup(body))
}

private fun Route.login() = post("/login") {
  val userSession = call.principal<UserSession>()

  call.sessions.set("user_session", userSession)

  call.respond(Response.ok(userSession?.user))
}

// TODO: Create a Page DTO for paginated collections
private fun Route.getAllUsers() = get("/all") {
  call.respondText("Placeholder")
}

// TODO: Figure out a solution to needing /user/
private fun Route.getUserById() = get("/user/{id}") {
  val id = call.getIntId()

  call.respond(UserService.getUserById(id))
}

private fun Route.deleteUser() = delete("/user/{id}") {
  val id = call.getIntId()

  call.respond(UserService.deleteUser(id))
}
