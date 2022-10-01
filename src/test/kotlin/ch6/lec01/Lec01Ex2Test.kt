package ch6.lec01

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 예제 6.2 상태 기반 테스트
 */
class Lec01Ex2Test {
    @Test
    fun adding_a_product_to_an_order() {
        // given-Arrange
        val product = Product("Hand wash")
        val sut = Order()

        // when-Act
        sut.addProduct(product)

        // then-Assert
        assertThat(sut.products.size).isEqualTo(1)
        assertThat(sut.products[0]).isEqualTo(product)

    }
}