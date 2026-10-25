package di

import data.database.DatabaseFactory
import data.repository.IssueReportRepositoryImpl
import data.repository.QuizQuestionRepositoryImpl
import data.repository.QuizTopicRepositoryImpl
import domain.repository.IssueReportRepository
import domain.repository.QuizQuestionRepository
import domain.repository.QuizTopicRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val koinModule = module {
    single { DatabaseFactory.createDatabase() }
    singleOf(::QuizQuestionRepositoryImpl).bind(QuizQuestionRepository::class)
    singleOf(::QuizTopicRepositoryImpl).bind(QuizTopicRepository::class)
    singleOf(::IssueReportRepositoryImpl).bind(IssueReportRepository::class)
}

