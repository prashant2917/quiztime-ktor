package presentation.config

import domain.repository.IssueReportRepository
import domain.repository.QuizQuestionRepository
import domain.repository.QuizTopicRepository
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import presentation.routes.issueReportRoutes
import presentation.routes.quizQuestionRoutes
import presentation.routes.quizTopicRoutes
import presentation.routes.root

fun Application.configureRouting() {
    install(Resources)

    val quizQuestionRepository: QuizQuestionRepository by inject()
    val quizTopicRepository: QuizTopicRepository by inject()
    val issueReportRepository: IssueReportRepository by inject()
    routing {
        root()
        quizQuestionRoutes(quizQuestionRepository)
        quizTopicRoutes(quizTopicRepository)
        issueReportRoutes(issueReportRepository)

        staticResources(
            remotePath = "/images",
            basePackage = "images"
        )


    }
}