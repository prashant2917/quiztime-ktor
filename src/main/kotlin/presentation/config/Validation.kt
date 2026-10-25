package presentation.config

import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import presentation.validator.validateIssueReport
import presentation.validator.validateQuizQuestion
import presentation.validator.validateQuizTopic

fun Application.configureValidation() {
    install(RequestValidation) {
        validateQuizQuestion() // Add validation logic here
        validateQuizTopic()
        validateIssueReport()
        // You can use Ktor's built-in validation features or integrate with external validation libraries
    }
}