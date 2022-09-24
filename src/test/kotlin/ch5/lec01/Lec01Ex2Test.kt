package ch5.lec01

import ch5.Controller
import ch5.IDatabase
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 예제 5.2 Mock 클래스를 사용해 스텁을 생성
 */
class Lec01Ex2Test {
    @Test
    fun creating_a_report() {
        // given-Arrange
        val stub = mockk<IDatabase>()   // Mock(도구)을 사용해 스텁 생성
        every { stub.getNumberOfUsers() } returns 10    // 준비된 응답 설정
        val sut = Controller(stub)

        // when-Act
        val report = sut.createReport()

        // then-Assert
        assertThat(report.numberOfUsers).isEqualTo(10)

    }
}