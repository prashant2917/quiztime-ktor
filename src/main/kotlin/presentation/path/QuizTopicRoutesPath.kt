package presentation.path

import io.ktor.resources.*

@Resource(path = "/quiz/topics")
class QuizTopicRoutesPath {

    @Resource(path = "{topicId}")
    data class ById(
        val parent: QuizTopicRoutesPath = QuizTopicRoutesPath(),
        val topicId: String
    )

}