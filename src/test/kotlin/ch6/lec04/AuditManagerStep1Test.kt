package ch6.lec04

import org.junit.jupiter.api.Test
import java.time.LocalDateTime

/**
 * 예제 6.8에 대한 테스트
 */
class AuditManagerStep1Test {
    @Test
    fun a_new_file_is_created_when_no_audit_exists() {
        // given-Arrange
        val sut = AuditManagerStep1(3, "/tmp/audit")
        // 1. /tmp/audit 디렉토리 새로 만들거나
        // 2. 기존에 있다면 디렉토리의 파일을 다 지우고

        // when-Act
        sut.addRecord("Aaron", LocalDateTime.now())

        // then-Assert
        // 1. /tmp/audit 디렉토리에 파일이 있는지 확인
        // 2. 파일의 내용이 맞는지도 확인


    }
}