package presentation.routes.quiz_questions

import domain.repository.QuizQuestionRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get


fun Route.getQuizQuestionById(quizQuestionRepository: QuizQuestionRepository) {
    // Implementation for fetching a quiz question by ID
    get("/quiz/questions/{questionId}") {
        // Logic to retrieve and respond with a quiz question by ID
        val id = call.parameters["questionId"]
        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing questionId parameter")
            return@get
        }
        val question = quizQuestionRepository.getQuizQuestionById(id)
        if (question != null) {
            call.respond(message = question, status = HttpStatusCode.OK) // Respond with the quiz question
        }
        else call.respond(message = "Question not found", status = HttpStatusCode.NotFound)
    }
}