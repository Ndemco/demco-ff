package com.demco

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.demco.plugins.*
import org.jetbrains.exposed.sql.Database

fun main() {
  embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    val db = Database.connect("jdbc:postgresql://db:5432/demco_ff", driver = "org.postgresql.Driver",
      user = "test", password = "password")
    configureSerialization()
    configureSecurity()
    configureRouting()
  }.start(wait = true)
}