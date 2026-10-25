package domain.repository

import domain.model.QuizTopic
import domain.util.DataError
import domain.util.Result

interface QuizTopicRepository {

    suspend fun getAllTopics(): Result<List<QuizTopic>, DataError>
    suspend fun upsertTopic(topic: QuizTopic): Result<Unit, DataError>
    suspend fun getTopicById(id: String?): Result<QuizTopic, DataError>
    suspend fun deleteTopicById(id: String?): Result<Unit, DataError>

}