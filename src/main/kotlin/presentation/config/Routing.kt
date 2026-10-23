package presentation.config

import data.database.DatabaseFactory
import data.repository.QuizQuestionRepositoryImpl
import domain.repository.QuizQuestionRepository
import io.ktor.server.application.Application
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import presentation.routes.quiz_questions.deleteQuizQuestionById
import presentation.routes.quiz_questions.getAllQuizQuestions
import presentation.routes.quiz_questions.getQuizQuestionById
import presentation.routes.quiz_questions.upsertQuizQuestion
import presentation.routes.root

fun Application.configureRouting() {
    val mongoDatabase = DatabaseFactory.createDatabase()
    val quizQuestionRepository: QuizQuestionRepository = QuizQuestionRepositoryImpl(mongoDatabase)
    routing {
       root()
       getAllQuizQuestions(quizQuestionRepository)
        upsertQuizQuestion(quizQuestionRepository)
        deleteQuizQuestionById(quizQuestionRepository)
        getQuizQuestionById(quizQuestionRepository)

    }
}