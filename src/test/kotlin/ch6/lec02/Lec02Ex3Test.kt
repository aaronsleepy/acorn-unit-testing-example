package ch6.lec02

import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

/**
 * 예제 6.5 값으로 비교하는 Comment
 */
class Lec02Ex3Test {
    @Test
    fun adding_a_comment_to_an_article() {
        // given-Arrange
        val text = "Comment text"
        val author = "John Doe"
        val now = LocalDateTime.now()
        val comment = Comment(text, author, now)
        val sut = Article()

        // when-Act
        sut.addComment(comment.text, comment.author, comment.dateCreated)

        // then-Assert
        sut.comments[0] shouldBe comment
    }
}