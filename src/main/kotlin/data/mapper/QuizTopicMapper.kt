package data.mapper

import data.database.entity.QuizTopicEntity
import domain.model.QuizTopic

fun QuizTopicEntity.toQuizTopic() = QuizTopic(
    id = _id,
    name = name,
    imageUrl = imageUrl,
    code = code
)

fun QuizTopic.toQuizTopicEntity(): QuizTopicEntity {
    return QuizTopicEntity(
        name = this.name,
        imageUrl = this.imageUrl,
        code = this.code
    )
}