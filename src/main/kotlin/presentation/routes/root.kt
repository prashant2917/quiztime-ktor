package presentation.routes

import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.root() {
    get("/") {
        call.respondText("Hello, Ktor server!")
    }
}