package com.demco

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.demco.plugins.*

fun main() {
  embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    Connect.db
    configureSerialization()
    //configureSecurity()
    configureRouting()
    configureSessions()
    configureAuth()
  }.start(wait = true)
}