package com.demco.rest.dto

import com.demco.rest.entity.User
import kotlinx.serialization.Serializable

fun User.toResponseDTO() = UserResponseDTO(id.value, firstName, lastName, username, email)

@Serializable
data class UserLoginDTO(
  val email: String,
  val password: String
)

@Serializable
data class UserRequestDTO(
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String
)

@Serializable
data class UserResponseDTO(
  val id: Int,
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String
)