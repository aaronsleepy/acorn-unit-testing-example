package ch3.lec14

import ch3.lec01.Calculator
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly

/**
 * 3.6 검증문 라이브러리를 사용한 테스트 가독성 향상
 * Fluent Assert by kotest
 * - IntelliJ에서 실행하려면 kotest 플러그인 설치해야 함
 */
internal class CalculatorTest : BehaviorSpec({
    val sut = Calculator()

    given("first and second is double") {
        val first = 10.0
        val second = 20.0
        `when`("sum by first and second") {
            val result = sut.sum(first, second)
            then("result is sum of them") {
              result shouldBeExactly 30.0
            }
        }
    }
})