package ch3.lec10

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DeliveryServiceTest {
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
}