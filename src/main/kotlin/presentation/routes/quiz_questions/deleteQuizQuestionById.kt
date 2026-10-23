package presentation.routes.quiz_questions

import domain.repository.QuizQuestionRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.deleteQuizQuestionById(quizQuestionRepository: QuizQuestionRepository) {
    delete("/quiz/questions/{questionId}") {
        // Logic to delete a quiz question by ID
        val id = call.parameters["questionId"]
        if (id == null) {
            call.respond(HttpStatusCode.BadRequest, "Missing questionId parameter")
            return@delete
        }
        val isDeleted = quizQuestionRepository.deleteQuizQuestionById(id)
        if (isDeleted) {
            call.respond(HttpStatusCode.NoContent)
        } else {
            call.respond(HttpStatusCode.NotFound, "Question not found")
        }
    }
}