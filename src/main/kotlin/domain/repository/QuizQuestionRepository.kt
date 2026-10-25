package domain.repository

import domain.model.QuizQuestion
import domain.util.DataError
import domain.util.Result

interface QuizQuestionRepository {
    suspend fun upsertQuizQuestion(quizQuestion: QuizQuestion): Result<Unit, DataError>
    suspend fun getRandomQuestions(topicCode: Int?, limit: Int?): Result<List<QuizQuestion>, DataError>
    suspend fun insertQuestionsInBulk(questions: List<QuizQuestion>): Result<Unit, DataError>
    suspend fun getAllQuizQuestions(topicCode: Int?): Result<List<QuizQuestion>, DataError>
    suspend fun getQuizQuestionById(id: String?): Result<QuizQuestion, DataError>
    suspend fun deleteQuizQuestionById(id: String?): Result<Unit, DataError>
}