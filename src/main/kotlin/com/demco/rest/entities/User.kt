package com.demco.rest.entities

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users: IntIdTable("users") {
  val firstName = varchar("first_name", 50)
  val lastName =  varchar("last_name", 50)
  val username = varchar("username", 50)
  val email = varchar("email", 250).uniqueIndex()
}

class User(id: EntityID<Int>) : IntEntity(id) {
  companion object : IntEntityClass<User>(Users)
  var firstName by Users.firstName
  var lastName by Users.lastName
  var username by Users.username
  var email by Users.email
}