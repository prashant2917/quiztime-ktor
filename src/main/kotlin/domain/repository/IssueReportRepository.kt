package domain.repository

import domain.model.IssueReport
import domain.util.DataError
import domain.util.Result

interface IssueReportRepository {
    suspend fun getAllIssueReports(): Result<List<IssueReport>, DataError>
    suspend fun insertIssueReport(report: IssueReport): Result<Unit, DataError>
    suspend fun deleteIssueReportById(id: String?): Result<Unit, DataError>
}