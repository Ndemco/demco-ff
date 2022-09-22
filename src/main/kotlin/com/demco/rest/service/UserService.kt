package com.demco.rest.service

import com.demco.core.ErrorMessage
import com.demco.core.Response
import com.demco.rest.dto.UserDTO
import com.demco.rest.dto.toDTO
import com.demco.rest.entity.Users
import org.jetbrains.exposed.sql.transactions.transaction

//TODO: validation and auth
object UserService {
  fun signup(user: UserDTO): Response<UserDTO, List<ErrorMessage>> {

    return Response.created(transaction { Users.create(user) }.toDTO())
  }

  fun getUserById(id: Int): Response<UserDTO, List<ErrorMessage>> {
    val user = transaction { Users.findById(id) } ?: return Response.notFound()

    return Response.ok(user.toDTO())
  }

  fun getUserByIdTest(id: Int): Response<UserDTO, List<ErrorMessage>> =
      transaction { Users.findById(id) }
        ?.let { Response.ok(it.toDTO()) }
        ?: Response.notFound()

  fun deleteUser(id: Int): Response<UserDTO, List<ErrorMessage>> =
    transaction { Users.delete(id) }
      ?.let { Response.ok(it.toDTO())}
      ?: Response.notFound()
}