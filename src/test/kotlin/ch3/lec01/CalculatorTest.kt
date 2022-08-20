package ch3.lec01

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CalculatorTest {                     // 응집도 있는 테스트 세트를 위한 클래스 컨테이너
    @Test                                           // 테스트를 나타내는 annotation
    @DisplayName("두 Double 숫자의 합을 정상 처리한다")    // 테스트를 표현하는 대체 문구
    fun sumOfTwoNumbers() {
        // given-Arrange: 준비
        val first = 10.0
        val second = 20.0
        val calculator = Calculator()

        // when-Act: 실행
        val result = calculator.sum(first, second)

        // then-Assert: 검증
        assertThat(result).isEqualTo(30.0)
    }
}