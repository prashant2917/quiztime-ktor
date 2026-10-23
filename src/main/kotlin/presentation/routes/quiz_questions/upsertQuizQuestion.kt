package presentation.routes.quiz_questions

import domain.model.QuizQuestion
import domain.repository.QuizQuestionRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.post


fun Route.upsertQuizQuestion(quizQuestionRepository: QuizQuestionRepository) {
    // Implementation for upserting a quiz question
    post("/quiz/questions") {
        // Logic to upsert a quiz question
        // You can retrieve the request body and perform the upsert operation here
        val quizQuestion = call.receive<QuizQuestion>() // Assuming you have a QuizQuestion data class
        quizQuestionRepository.upsertQuizQuestion(quizQuestion) // Call the repository method to upsert the quiz question
        call.respond(message = "Quiz question added successfully!",
            status = HttpStatusCode.Created
            )
    }
}

