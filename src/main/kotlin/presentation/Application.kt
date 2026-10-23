package presentation

import domain.model.QuizQuestion
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import presentation.config.configureLogging
import presentation.config.configureRouting
import presentation.config.configureSerialization

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
   configureRouting()
   configureSerialization()
    configureLogging()
}

