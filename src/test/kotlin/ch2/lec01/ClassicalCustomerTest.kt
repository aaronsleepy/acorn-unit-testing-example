package ch2.lec01

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 예제 2.1 고전적인 스타일로 작성된 테스트
 */
class ClassicalCustomerTest {
    @Test
    @DisplayName("재고가 충분한 경우 구매는 정상 처리된다")
    fun purchaseSucceedsWhenEnoughInventory() {
        // given-Arrange
        val store = Store()
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // when-Act
        val success = customer.purchase(store, Product.Shampoo, 5)

        // then-Assert
        assertThat(success).isTrue
        assertThat(store.getInventory(Product.Shampoo)).isEqualTo(5) // <-- 상점 제품 다섯 개 감소
    }

    @Test
    @DisplayName("재고가 부족한 경우 구매는 실패하고 재고는 유지된다")
    fun purchaseFailsWhenNotEnoughInventory() {
        // given-Arrange
        val store = Store()
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // when-Act
        val success = customer.purchase(store, Product.Shampoo, 15)

        // then-Assert
        assertThat(success).isFalse
        assertThat(store.getInventory(Product.Shampoo)).isEqualTo(10) // <-- 상점 제품 수량 변화 없음
    }
}