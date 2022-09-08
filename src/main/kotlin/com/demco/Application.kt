package com.demco

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.demco.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureSerialization()
        configureSecurity()
        configureRouting()
    }.start(wait = true)
}
