package com.demco.plugins

import com.demco.rest.route.userRoutes
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    install(StatusPages) {
        exception<AuthenticationException> { call, cause ->
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> { call, cause ->
            call.respond(HttpStatusCode.Forbidden)
        }
    
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        userRoutes()
    }
}
class AuthenticationException : RuntimeException()
class AuthorizationException : RuntimeException()
