package ch3.lec03

import ch2.lec01.Customer
import ch2.lec01.Product
import ch2.lec01.Store
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 예제 3.8 비공개 팩토리 메서드로 도출한 공통 초기화 코드
 * - 더 나은 방법
 * - 비공개 팩토리 메서드를 사용하기
 */
internal class GoodTestFixtureByFactoryMethodCustomerTest {
    @Test
    @DisplayName("재고가 충분한 경우 구매는 정상 처리된다")
    fun purchaseSucceedsWhenEnoughInventory() {
        // given-Arrange
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        // when-Act
        val success = sut.purchase(store, Product.Shampoo, 5)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isTrue
        AssertionsForInterfaceTypes.assertThat(store.getInventory(Product.Shampoo)).isEqualTo(5) // <-- 상점 제품 다섯 개 감소
    }

    @Test
    @DisplayName("재고가 부족한 경우 구매는 실패하고 재고는 유지된다")
    fun purchaseFailsWhenNotEnoughInventory() {
        // given-Arrange
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        // when-Act
        val success = sut.purchase(store, Product.Shampoo, 15)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isFalse
        AssertionsForInterfaceTypes.assertThat(store.getInventory(Product.Shampoo)).isEqualTo(10) // <-- 상점 제품 수량 변화 없음
    }

    private fun createStoreWithInventory(product: Product, quantity: Int): Store {
        return Store()
            .apply { addInventory(Product.Shampoo, 10) }
    }

    companion object {
        private fun createCustomer(): Customer = Customer()
    }
}