package com.demco

import com.demco.db.Connect
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.demco.plugins.*

fun main() {
  embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    Connect.db
    configureSerialization()
    configureSecurity()
    configureRouting()
    configureSessions()
  }.start(wait = true)
}