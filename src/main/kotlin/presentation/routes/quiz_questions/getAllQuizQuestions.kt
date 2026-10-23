package presentation.routes.quiz_questions

import domain.repository.QuizQuestionRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllQuizQuestions(quizQuestionRepository: QuizQuestionRepository) {
    // Implementation for fetching all quiz questions
    get("/quiz/questions") {
        // Logic to retrieve and respond with all quiz questions
        val topicCode = call.queryParameters["topicCode"]?.toIntOrNull() // Get the topicCode query parameter
        val limit = call.request.queryParameters["limit"]?.toIntOrNull()
        val questions = quizQuestionRepository.getAllQuizQuestions(topicCode, limit)
        if(questions.isNotEmpty()){
            call.respond(message = questions, status = HttpStatusCode.OK) // Respond with the filtered quiz questions
        } else {
            call.respond(message = "No questions found", status = HttpStatusCode.NotFound)
        }

    }
}