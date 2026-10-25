package presentation.routes

import domain.model.IssueReport
import domain.repository.IssueReportRepository
import domain.util.onFailure
import domain.util.onSuccess
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.Route
import presentation.path.IssueReportRoutesPath
import presentation.util.respondWithError

fun Route.issueReportRoutes(
    repository: IssueReportRepository
) {

    post<IssueReportRoutesPath> {
        val report = call.receive<IssueReport>()
        repository.insertIssueReport(report)
            .onSuccess {
                call.respond(
                    message = "Report submitted successfully",
                    status = HttpStatusCode.Created
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    get<IssueReportRoutesPath> {
        repository.getAllIssueReports()
            .onSuccess { reports ->
                call.respond(
                    message = reports,
                    status = HttpStatusCode.OK
                )
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }

    delete<IssueReportRoutesPath.ById> { path ->
        repository.deleteIssueReportById(path.reportId)
            .onSuccess {
                call.respond(HttpStatusCode.NoContent)
            }
            .onFailure { error ->
                respondWithError(error)
            }
    }


}