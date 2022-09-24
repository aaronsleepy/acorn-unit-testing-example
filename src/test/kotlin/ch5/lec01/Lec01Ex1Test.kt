package ch5.lec01

import ch5.Controller
import ch5.IEmailGateway
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

/**
 * 예제 5.1 목 라이브러리에서 Mock 클래스를 사용해 목을 생성
 */
class Lec01Ex1Test {
    @Test
    fun sending_a_greetings_email() {
        // given-Arrange
        val mock = mockk<IEmailGateway>()   // Mock(도구)으로 mock(목) 생성
        every { mock.sendGreetingsEmail("aaron@kmong.com") } returns Unit
        val sut = Controller(mock)

        // when-Act
        sut.greetUser("aaron@kmong.com")


        // then-Assert
        verify(exactly = 1) {
            mock.sendGreetingsEmail("aaron@kmong.com") }    // 테스트 대역으로 하는 SUT의 호출 검사
    }
}