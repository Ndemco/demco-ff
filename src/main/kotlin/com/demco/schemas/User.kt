package com.demco.schemas

import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Long, val firstName: String, val lastName: String, val email: String) {

}

val userDb = mutableListOf<User>();