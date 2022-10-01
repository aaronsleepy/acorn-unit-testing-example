package ch6.lec02

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertNotNull

/**
 * 예제 6.5 검증문에 헬퍼 메서드 사용
 * - 확장 함수 사용하여 Helper 구현
 */
class Lec02Ex2Test {
    @Test
    fun adding_a_comment_to_an_article() {
        // given-Arrange
        val text = "Comment text"
        val author = "John Doe"
        val now = LocalDateTime.now()
        val sut = Article()

        // when-Act
        sut.addComment(text, author, now)

        // then-Assert
        sut.shouldContainNumberOfComments(1)
            .withComment(text, author, now)
    }
}

fun Article.shouldContainNumberOfComments(commentCount: Int): Article {
    assertThat(commentCount).isEqualTo(1)
    return this
}

fun Article.withComment(text: String, author: String, dateCreated: LocalDateTime): Article {
    val comment = comments.firstOrNull {
        it.text == text && it.author == author && it.dateCreated == dateCreated
    }

    assertNotNull(comment)
    return this
}