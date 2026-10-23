package data.repository

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import data.util.Constants.QUIZ_QUESTIONS_COLLECTION_NAME
import domain.model.QuizQuestion
import domain.repository.QuizQuestionRepository

class QuizQuestionRepositoryImpl(mongoDatabase: MongoDatabase): QuizQuestionRepository {

    private val quizQuestions = mutableListOf<QuizQuestion>() // In-memory storage for quiz questions
   private val questionCollection = mongoDatabase.getCollection<QuizQuestion>(QUIZ_QUESTIONS_COLLECTION_NAME)
    override suspend fun upsertQuizQuestion(quizQuestion: QuizQuestion) {
        questionCollection.insertOne(quizQuestion)
    }

    override suspend fun getAllQuizQuestions(
        topicCode: Int?,
        limit: Int?
    ): List<QuizQuestion> {
     return if(topicCode != null) {
            quizQuestions.filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions.take(limit ?: quizQuestions.size)
        }// Limit the number of questions if limit is provided

    }

    override suspend fun getQuizQuestionById(id: String): QuizQuestion? {
      return  quizQuestions.find { it.id == id }
    }

    override suspend fun deleteQuizQuestionById(id: String): Boolean {
       return quizQuestions.removeIf { it.id == id }
    }
}