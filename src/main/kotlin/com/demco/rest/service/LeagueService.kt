package com.demco.rest.service

import com.demco.core.ErrorMessage
import com.demco.core.Response
import com.demco.rest.dto.LeagueRequestDTO
import com.demco.rest.dto.LeagueResponseDTO
import com.demco.rest.dto.toResponseDTO
import com.demco.rest.entity.Leagues
import com.demco.rest.entity.Users
import org.jetbrains.exposed.sql.transactions.transaction

object LeagueService {
  fun create(league: LeagueRequestDTO): Response<LeagueResponseDTO, List<ErrorMessage>> {
    return Response.created(transaction { Leagues.create(league) }.toResponseDTO())
  }

  fun delete(id: Int): Response<Nothing, List<ErrorMessage>> =
    transaction { Leagues.delete(id) }
      ?.let { Response.ok()}
      ?: Response.notFound()
}