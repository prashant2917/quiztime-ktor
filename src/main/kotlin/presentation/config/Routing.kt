package presentation.config

import io.ktor.server.application.Application
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import presentation.routes.quiz_questions.getAllQuizQuestions
import presentation.routes.root

fun Application.configureRouting() {
    routing {
       root()
       getAllQuizQuestions()

    }
}