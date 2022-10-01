package ch6.lec02

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

/**
 * 예제 6.4 많은 공간을 차지하는 상태 검증
 */
class Lec02Ex1Test {
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
        assertThat(sut.comments.size).isEqualTo(1)
        assertThat(sut.comments[0].text).isEqualTo(text)
        assertThat(sut.comments[0].author).isEqualTo(author)
        assertThat(sut.comments[0].dateCreated).isEqualTo(now)
    }
}