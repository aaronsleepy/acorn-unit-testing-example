package ch3.lec03

import ch2.lec01.Customer
import ch2.lec01.Product
import ch2.lec01.Store
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * 3.3 테스트 간 테스트 픽스처 재사용
 * - 올바르지 않은 방법
 * - Test 생성자에서 테스트 픽스처를 초기화하는 방식
 */
internal class BadTestFixtureCustomerTest {
    private val _store: Store = Store()
    private val _sut: Customer = Customer()

    init {
        _store.addInventory(Product.Shampoo, 10)
    }

    @Test
    @DisplayName("재고가 충분한 경우 구매는 정상 처리된다")
    fun purchaseSucceedsWhenEnoughInventory() {
        // when-Act
        val success = _sut.purchase(_store, Product.Shampoo, 5)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isTrue
        AssertionsForInterfaceTypes.assertThat(_store.getInventory(Product.Shampoo)).isEqualTo(5) // <-- 상점 제품 다섯 개 감소
    }

    @Test
    @DisplayName("재고가 부족한 경우 구매는 실패하고 재고는 유지된다")
    fun purchaseFailsWhenNotEnoughInventory() {
        // when-Act
        val success = _sut.purchase(_store, Product.Shampoo, 15)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(success).isFalse
        AssertionsForInterfaceTypes.assertThat(_store.getInventory(Product.Shampoo)).isEqualTo(10) // <-- 상점 제품 수량 변화 없음
    }
}