package ch6.lec01

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 예제 6.1 출력 기반 테스트
 */
class Lec01Ex1Test {
    @Test
    fun discount_of_two_products() {
        // given-Arrange
        val product1 = Product("Hand wash")
        val product2 = Product("Shampoo")
        val sut = PriceEngine()

        // when-Act
        val discount = sut.calculateDiscount(product1, product2)

        // then-Assert
        assertThat(discount).isEqualTo(0.02)

    }
}