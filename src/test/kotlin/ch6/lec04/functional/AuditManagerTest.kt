package ch6.lec04.functional

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 예제 6.15 목 없이 작성된 테스트
 */
class AuditManagerTest {
    @Test
    fun a_new_file_is_created_whe_the_current_file_overflows() {
        // given-Arrange
        val fileContents = listOf(
            FileContent(File("audit_1.txt"), mutableListOf()),
            FileContent(File("audit_2.txt"), mutableListOf(
                "Peter; 2019-04-06T16:30:00",
                "Jane; 2019-04-06T16:40:00",
                "Jack; 2019-04-06T17:00:00"
            )),
        )

        val sut = AuditManager(3)

        // when-Act
        val update = sut.addRecord(fileContents, "Alice", LocalDateTime.parse("2019-04-06T18:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))

        // then-Assert
        assertThat(update.fileName).isEqualTo("audit_3.txt")
        assertThat(update.newContent).isEqualTo("Alice;2019-04-06T18:00:00")
    }
}