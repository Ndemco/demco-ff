package com.demco.rest.dto

import com.demco.rest.entities.User
import kotlinx.serialization.Serializable

fun User.toDTO() = UserDTO(firstName, lastName, username, email)

@Serializable
data class UserDTO(
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String
)