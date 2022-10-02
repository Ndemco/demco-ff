package com.demco.rest.service

import com.demco.core.ErrorMessage
import com.demco.core.Response
import com.demco.rest.dto.UserLoginDTO
import com.demco.rest.dto.UserRequestDTO
import com.demco.rest.dto.UserResponseDTO
import com.demco.rest.dto.toResponseDTO
import com.demco.rest.entity.Users
import org.jetbrains.exposed.sql.transactions.transaction

//TODO: validation and auth
object UserService {
  fun signup(user: UserRequestDTO): Response<UserResponseDTO, List<ErrorMessage>> {

    return Response.created(transaction { Users.create(user) }.toResponseDTO())
  }

  fun login(user: UserLoginDTO): Response<UserResponseDTO, List<ErrorMessage>> =
    transaction { Users.findByEmail(user.email) }
      ?.let { Response.ok(it.toResponseDTO()) }
      ?: Response.notFound()


  fun getUserById(id: Int): Response<UserResponseDTO, List<ErrorMessage>> =
      transaction { Users.findById(id) }
        ?.let { Response.ok(it.toResponseDTO()) }
        ?: Response.notFound()

  fun deleteUser(id: Int): Response<UserResponseDTO, List<ErrorMessage>> =
    transaction { Users.delete(id) }
      ?.let { Response.ok(it.toResponseDTO())}
      ?: Response.notFound()
}