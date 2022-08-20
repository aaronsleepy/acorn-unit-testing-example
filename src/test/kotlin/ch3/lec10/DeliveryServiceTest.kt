package ch3.lec10

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DeliveryServiceTest {
    /**
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
}