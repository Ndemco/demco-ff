package com.demco.rest.route

import com.demco.core.respond
import com.demco.rest.dto.UserDTO
import com.demco.rest.service.UserService
import com.demco.util.getIntId
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import io.ktor.server.routing.post
import io.ktor.server.routing.get
import io.ktor.server.routing.delete

fun Route.userRoutes() = route("/users") {
  signup()
  getAllUsers()
  getUserById()
  deleteUser()
}

private fun Route.signup() = post<UserDTO>("/signup") { body ->

  call.respond(UserService.signup(body))
}

private fun Route.getAllUsers() = get("/all") {
  call.respondText("Placeholder")
}

private fun Route.getUserById() = get("/{id}") {
  val id = call.getIntId()

  call.respond(UserService.getUserByIdTest(id))
}

private fun Route.deleteUser() = delete("/{id}") {
  val id = call.getIntId()

  call.respond(UserService.deleteUser(id))
}