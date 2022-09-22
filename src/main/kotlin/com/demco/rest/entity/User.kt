package com.demco.rest.entity

import com.demco.rest.dto.UserDTO
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import java.util.*

object Users: IntIdTable("users") {
  val firstName = varchar("first_name", 50)
  val lastName =  varchar("last_name", 50)
  val username = varchar("username", 50)
  val email = varchar("email", 250).uniqueIndex()

  fun create(user: UserDTO): User =
    User.new {
      firstName = user.firstName
      lastName = user.lastName
      username = user.username
      email = user.email
    }

  fun findById(id: Int): User? = User.findById(id)

  fun findByUsername(username: String): User? =
    User.find { Users.username eq username }
      .firstOrNull()

  fun findByEmail(email: String): User? =
    User.find{ Users.email eq email}
      .firstOrNull()

  fun delete(id: Int): User? =
    User.findById(id)
      ?.apply{ delete() }
}

class User(id: EntityID<Int>) : IntEntity(id) {
  companion object : IntEntityClass<User>(Users)
  var firstName by Users.firstName
  var lastName by Users.lastName
  var username by Users.username
  var email by Users.email
}