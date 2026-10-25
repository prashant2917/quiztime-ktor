package presentation.routes

import domain.model.QuizQuestion
import domain.repository.QuizQuestionRepository
import domain.util.onFailure
import domain.util.onSuccess
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import presentation.path.QuizQuestionRoutesPath
import presentation.util.respondWithError

fun Route.quizQuestionRoutes(
    repository: QuizQuestionRepository
) {

    post<QuizQuestionRoutesPath> {
        val question = call.receive<QuizQuestion>()
        repository.upsertQuizQuestion(question)
            .onSuccess {
                call.respond(
                    message = "Question added successfully",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    post<QuizQuestionRoutesPath.Bulk> {
        val quizQuestion = call.receive<List<QuizQuestion>>()
        repository.insertQuestionsInBulk(quizQuestion)
            .onSuccess {
                call.respond(
                    message = "Quiz Questions added",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath> { path ->
        repository.getAllQuizQuestions(path.topicCode)
            .onSuccess { questions ->
                call.respond(
                    message = questions,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath.Random> { path ->
        repository.getRandomQuestions(path.topicCode, path.limit)
            .onSuccess { questions ->
                call.respond(
                    message = questions,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizQuestionRoutesPath.ById> { path ->
        repository.getQuizQuestionById(path.questionId)
            .onSuccess { question ->
                call.respond(
                    message = question,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<QuizQuestionRoutesPath.ById> { path ->
        repository.deleteQuizQuestionById(path.questionId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

}