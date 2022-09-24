package ch5.lec03

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test

/**
 * 예제 5.11 취약한 테스트로 이어지는 목 사용
 * - 2장의 LondonCustomerTest#purchaseSucceedsWhenEnoughInventory 와 동일
 */
class Lec03Ex11 {
    @Test
    fun purchase_succeeds_when_enough_inventory() {
        // given-Arrange
        val mockStore = mockk<IStore>()
        every { mockStore.hasEnoughInventory(Product.Shampoo, 5) } returns true
        every { mockStore.removeInventory(Product.Shampoo, 5) } returns Unit
        val customer = Customer()

        // when-Act
        val success = customer.purchase(mockStore, Product.Shampoo, 5)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isTrue
        verify(exactly = 1) { mockStore.removeInventory(Product.Shampoo, 5) }
    }
}
