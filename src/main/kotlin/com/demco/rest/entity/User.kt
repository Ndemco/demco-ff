package com.demco.rest.entity

import at.favre.lib.crypto.bcrypt.BCrypt
import com.demco.rest.dto.UserRequestDTO
import org.bson.codecs.pojo.annotations.BsonId
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.litote.kmongo.Id

object Users: IntIdTable("users") {
  val firstName = varchar("first_name", 64)
  val lastName =  varchar("last_name", 64)
  val username = varchar("username", 64)
  val email = varchar("email", 255).uniqueIndex()
  val password = varchar("password", 64)

  fun create(user: UserRequestDTO): User =
    User.new {
      firstName = user.firstName
      lastName = user.lastName
      username = user.username
      email = user.email
      password = BCrypt.withDefaults().hashToString(12, user.password.toCharArray())
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
  var password by Users.password
}

data class UserM(
  @BsonId
  val id: Id<UserM>? = null,
  val firstName: String,
  val lastName: String,
  val username: String,
  val email: String,
  val password: String
)