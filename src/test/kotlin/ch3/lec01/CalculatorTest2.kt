package ch3.lec01

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 테스트 내 SUT 이름을 sut로 하라
 */
internal class CalculatorTest2 {
    @Test
    @DisplayName("두 Double 숫자의 합을 정상 처리한다")
    fun sumOfTwoNumbers() {
        // given-Arrange: 준비
        val first = 10.0
        val second = 20.0
        val sut = Calculator() // Calculator를 이제 sut라고 한다

        // when-Act: 실행
        val result = sut.sum(first, second)

        // then-Assert: 검증
        assertThat(result).isEqualTo(30.0)
    }
}