package com.demco.rest.route

import com.demco.core.Response
import com.demco.core.respond
import com.demco.util.getIntId
import io.ktor.server.application.*
import io.ktor.server.routing.*

object LeagueRoutes {
  fun Route.leagueRoutes() = route("/leagues") {

  }

  private fun Route.getLeaguesByUserId() = get("/{userId}") {
    val userId = call.getIntId("userId")

    call.respond(Response.ok())
  }
}