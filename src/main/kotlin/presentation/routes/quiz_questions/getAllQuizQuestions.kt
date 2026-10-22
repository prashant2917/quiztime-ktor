package presentation.routes.quiz_questions

import domain.model.QuizQuestion
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions() {
    // Implementation for fetching all quiz questions
    get("/quiz/questions") {
        // Logic to retrieve and respond with all quiz questions
        val question = QuizQuestion(

            question = "What is the capital of France?",
            correctAnswer = "Paris",
            incorrectAnswers = listOf("London", "Berlin", "Madrid"),
            explanation = "Paris is the capital and most populous city of France.",
            topicCode = 101
        )

        call.respond(question) // Respond with the quiz question as a string
    }
}