package com.demco.rest.routes

import com.demco.rest.dto.UserDTO
import com.demco.rest.dto.toDTO
import com.demco.rest.entities.User
import com.demco.util.getIntId
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.userRoutes() = route("/users") {
  signup()
  getAllUsers()
  getUserById()
  deleteUser()
}

private fun Route.signup() = post<UserDTO>("/signup") { body ->
  val user = transaction { User.new {
      firstName = body.firstName
      lastName = body.lastName
      username = body.username
      email = body.email
    }
  }

  call.respond(user)
}

private fun Route.getAllUsers() = get("/all") {
  call.respondText("Placeholder")
}

private fun Route.getUserById() = get("/{id}") {
  val id = call.getIntId()

  val user = transaction { User.findById(id) } ?: return@get call.respondText(
    "No user with id $id",
    status = HttpStatusCode.NotFound
  )
  call.respond(user.toDTO())
}

private fun Route.deleteUser() = delete("/{id}") {
  val id = call.getIntId()

  val user = transaction { User.findById(id) } ?.apply { transaction { delete() } } ?: return@delete call.respondText(
    "No user with ID $id",
    status = HttpStatusCode.NotFound
  )

  call.respond(user.toDTO())
}