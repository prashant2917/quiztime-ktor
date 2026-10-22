package presentation

import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import presentation.config.configureRouting

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
   configureRouting()
}