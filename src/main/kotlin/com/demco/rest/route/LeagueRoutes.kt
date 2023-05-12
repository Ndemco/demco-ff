package com.demco.rest.route

import com.demco.core.respond
import com.demco.rest.dto.LeagueRequestDTO
import com.demco.rest.service.LeagueService
import com.demco.util.getIntId
import io.ktor.server.application.*
import io.ktor.server.routing.*

object LeagueRoutes {
  fun Route.leagueRoutes() = route("/leagues") {
    create()
    delete()
  }

  private fun Route.create() = post<LeagueRequestDTO> { body ->
    call.respond(LeagueService.create(body))
  }

  private fun Route.delete() = delete("/{id}") {
    val id = call.getIntId()

    call.respond(LeagueService.delete(id))
  }
}