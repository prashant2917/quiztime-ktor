package presentation.routes

import domain.model.QuizTopic
import domain.repository.QuizTopicRepository
import domain.util.onFailure
import domain.util.onSuccess
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import presentation.path.QuizTopicRoutesPath
import presentation.util.respondWithError

fun Route.quizTopicRoutes(
    repository: QuizTopicRepository
) {

    post<QuizTopicRoutesPath> {
        val quizTopic = call.receive<QuizTopic>()
        repository.upsertTopic(quizTopic)
            .onSuccess {
                call.respond(
                    message = "Quiz Topic added",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizTopicRoutesPath> {
        repository.getAllTopics()
            .onSuccess { topics ->
                call.respond(
                    message = topics,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<QuizTopicRoutesPath.ById> { path ->
        repository.getTopicById(path.topicId)
            .onSuccess { quizTopic ->
                call.respond(
                    message = quizTopic,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<QuizTopicRoutesPath.ById> { path ->
        repository.deleteTopicById(path.topicId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

}