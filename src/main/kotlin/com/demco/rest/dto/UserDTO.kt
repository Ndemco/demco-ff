package com.demco.rest.dto

import com.demco.rest.entity.User
import com.demco.rest.entity.UserM
import kotlinx.serialization.Serializable

fun User.toResponseDTO() = UserResponseDTO(id.value, firstName, lastName, username, email)

fun UserM.toResponseDTO() = UserMResponseDTO(id.toString(), firstName, lastName, username, email)

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
  val email: String,
  val password: String
)

@Serializable
data class UserResponseDTO(
  val id: Int,
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String
)

@Serializable
data class UserMLoginDTO(
  val email: String,
  val password: String
)

@Serializable
data class UserMRequestDTO(
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String,
  val password: String
)

@Serializable
data class UserMResponseDTO(
  val id: String,
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String
)