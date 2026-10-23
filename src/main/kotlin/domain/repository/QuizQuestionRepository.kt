package domain.repository

import domain.model.QuizQuestion

interface QuizQuestionRepository {
 suspend fun upsertQuizQuestion(quizQuestion: QuizQuestion)
 suspend fun getAllQuizQuestions(topicCode: Int?, limit:Int?): List<QuizQuestion>
 suspend fun getQuizQuestionById(id: String): QuizQuestion?
 suspend fun deleteQuizQuestionById(id: String): Boolean
}