package ch6.lec04

import io.kotest.mpp.file
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

/**
 * 예제 6.11 목을 이용한 감사 시스템의 동작 확인
 */
class AuditManagerStep2Test {
    @Test
    fun a_new_file_is_created_when_the_current_file_overflows() {
        // given-Arrange
        val fileSystemMock = mockk<IFileSystem>()
        every { fileSystemMock.getFiles("audits") } returns
                arrayOf(File("audits/audit_1.txt"), File("audits/audit_2.txt"))
        every { fileSystemMock.readAllLines(
            Paths.get("audits/audit_2.txt")) } returns listOf(
            "Peter; 2019-04-06T16:30:00",
            "Jane; 2019-04-06T16:40:00",
            "Jack; 2019-04-06T17:00:00")
        every { fileSystemMock.writeAllText(
            Paths.get("audits/audit_3.txt"), "Alice;2019-04-06T18:00:00") } returns Unit

        val sut = AuditManagerStep2(3, "audits", fileSystemMock)

        // when-Act
        sut.addRecord("Alice", LocalDateTime.parse("2019-04-06T18:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")))

        // then-Assert
        verify { fileSystemMock.writeAllText(Paths.get("audits/audit_3.txt"), "Alice;2019-04-06T18:00:00") }
    }
}