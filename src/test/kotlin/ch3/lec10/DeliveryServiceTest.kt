package ch3.lec10

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

/**
 * 3.4.2 예제: 지침에 따른 테스트 이름 변경
 */
class DeliveryServiceTest {
    /**
     * 예제 3.10 엄격한 정책으로 명명된 테스트
     * 모호한 테스트 이름
     */
    @Test
    fun isDeliveryValid_invalidDate_returnsFalse() {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().minusDays(1)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        assertThat(isValid).isFalse
    }

    /**
     * 더 나은 테스트 이름
     */
    @Test
    fun delivery_with_a_past_date_is_invalid() {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().minusDays(1)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        assertThat(isValid).isFalse
    }

    /**
     * 더 나은 한글 테스트 명명법 with @DisplayName
     */
    @Test
    @DisplayName("과거 날짜의 Delivery는 유효하지 않다")
    fun any_meaningful_test_name() {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().minusDays(1)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        assertThat(isValid).isFalse
    }
}