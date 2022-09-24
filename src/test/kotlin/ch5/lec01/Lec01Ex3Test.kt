package ch5.lec01

import ch5.Controller
import ch5.IDatabase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 예제 5.3 스텁으로 상호 작용 검증
 */
class Lec01Ex3Test {
    @Test
    fun creating_a_report() {
        // given-Arrange
        val stub = mockk<IDatabase>()
        every { stub.getNumberOfUsers() } returns 10
        val sut = Controller(stub)

        // when-Act
        val report = sut.createReport()

        // then-Assert
        assertThat(report.numberOfUsers).isEqualTo(10)
        verify(exactly = 1) { stub.getNumberOfUsers() } // 스텁으로 상호 작용 검증

    }
}