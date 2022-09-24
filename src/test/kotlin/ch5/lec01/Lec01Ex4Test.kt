package ch5.lec01

import ch2.lec01.Customer
import ch2.lec01.Product
import ch2.lec01.Store
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test

/**
 * 예제 5.4 목이자 스텁인 storeMock
 * - 예제 2.2의 LondonCustomerTest#purchaseFailsWhenNotEnoughInventory()와 동일
 */
class Lec01Ex4Test {
    @Test
    fun purchase_fails_when_not_enough_inventory() {
        // given-Arrange
        val mockStore = mockk<Store>()
        every { mockStore.hasEnoughInventory(
            Product.Shampoo, 5) } returns false // 준비된 응답을 설정
        val customer = Customer()

        // when-Act
        val success = customer.purchase(mockStore, Product.Shampoo, 5)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isFalse
        verify(exactly = 0) { mockStore.removeInventory(
            Product.Shampoo, 5) }   // SUT에서 수행한 호출을 검사

    }
}