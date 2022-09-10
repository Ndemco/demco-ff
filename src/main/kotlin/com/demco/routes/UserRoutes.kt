package com.demco.routes

import com.demco.schemas.User
import com.demco.schemas.userDb
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting() {
  route("/user") {
    get {
      if (userDb.isNotEmpty()) {
        call.respond(userDb)
      } else {
        call.respondText("No users found", status = HttpStatusCode.OK)
      }
    }
    get("{id?}") {
      val id = call.parameters["id"] ?: return@get call.respondText("Missing ID", status = HttpStatusCode.BadRequest)

      val user = userDb.find {it.id == id.toLong()} ?: return@get call.respondText(
        "No customer with id $id",
        status = HttpStatusCode.NotFound
      )
      call.respond(user)
    }
    post {
      val user = call.receive<User>()
      userDb.add(user);
      call.respondText("User stored correctly", status = HttpStatusCode.Created)
    }
    delete("{id?}") {
      val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)

      if (userDb.removeIf {it.id == id.toLong()}) {
        call.respondText("User removed correctly", status = HttpStatusCode.Accepted)
      } else {
        call.respondText("Not found", status = HttpStatusCode.NotFound)
      }
    }
  }
}