package ch6.lec01

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

/**
 * 예제 6.3 통신 기반 테스트
 */
class Lec01Ex3Test {
    @Test
    fun sending_a_greetings_email() {
        // given-Arrange
        val emailGatewayMock = mockk<IEmailGateway>()
        every { emailGatewayMock.sendGreetingsEmail("aaron@kmong.com") } returns Unit
        val sut = Controller(emailGatewayMock)

        // when-Act
        sut.greetUser("aaron@kmong.com")

        // then-Assert
        verify(exactly = 1) { emailGatewayMock.sendGreetingsEmail("aaron@kmong.com") }
    }
}