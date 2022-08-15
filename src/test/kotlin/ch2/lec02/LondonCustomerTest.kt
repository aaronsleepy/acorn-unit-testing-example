package ch2.lec02

import ch2.lec01.Customer
import ch2.lec01.Product
import ch2.lec01.Store
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LondonCustomerTest {
    @Test
    @DisplayName("재고가 충분한 경우 구매는 정상 처리된다")
    fun purchaseSucceedsWhenEnoughInventory() {
        // given-Arrange
        val mockStore = mockk<Store>()
        every { mockStore.hasEnoughInventory(Product.Shampoo, 5) } returns true
        every { mockStore.removeInventory(Product.Shampoo, 5) } returns Unit
        val customer = Customer()

        // when-Act
        val success = customer.purchase(mockStore, Product.Shampoo, 5)

        // then-Assert
        assertThat(success).isTrue
        verify(exactly = 1) { mockStore.removeInventory(Product.Shampoo, 5) }
    }

    @Test
    @DisplayName("재고가 부족한 경우 구매는 실패하고 재고는 유지된다")
    fun purchaseFailsWhenNotEnoughInventory() {
        // given-Arrange
        val mockStore = mockk<Store>()
        every { mockStore.hasEnoughInventory(Product.Shampoo, 5) } returns false
        val customer = Customer()

        // when-Act
        val success = customer.purchase(mockStore, Product.Shampoo, 5)

        // then-Assert
        assertThat(success).isFalse
        verify(exactly = 0) { mockStore.removeInventory(Product.Shampoo, 5) }
    }
}