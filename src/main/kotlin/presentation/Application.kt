package presentation

import io.ktor.server.application.*
import io.ktor.server.netty.*
import presentation.config.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureKoin()
    configureRouting()
    configureSerialization()
    configureLogging()
    configureValidation()
    configureStatusPages()
}

