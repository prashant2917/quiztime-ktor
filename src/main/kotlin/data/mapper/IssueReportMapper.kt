package data.mapper

import data.database.entity.IssueReportEntity
import domain.model.IssueReport

fun IssueReportEntity.toIssueReport() = IssueReport(
    id = _id,
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestamp
)

fun IssueReport.toIssueReportEntity() = IssueReportEntity(
    questionId = questionId,
    issueType = issueType,
    additionalComment = additionalComment,
    userEmail = userEmail,
    timestamp = timestamp
)