package data.mapper

import data.database.entity.QuizQuestionEntity
import domain.model.QuizQuestion

fun QuizQuestionEntity.toQuizQuestion(): QuizQuestion {
    return QuizQuestion(
        id = this._id,
        question = this.question,
        correctAnswer = this.correctAnswer,
        incorrectAnswers = this.incorrectAnswers,
        explanation = this.explanation,
        topicCode = this.topicCode
    )
}

fun QuizQuestion.toQuizQuestionEntity(): QuizQuestionEntity {
    return QuizQuestionEntity(
        question = this.question,
        correctAnswer = this.correctAnswer,
        incorrectAnswers = this.incorrectAnswers,
        explanation = this.explanation,
        topicCode = this.topicCode
    )
}