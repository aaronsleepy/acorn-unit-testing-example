package ch3.lec12

import ch3.lec10.Delivery
import ch3.lec10.DeliveryService
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

/**
 * 예제 3.12 긍정적인 시나리오와 부정적인 시나리오를 검증하는 두 가지 테스트
 * - Ref: https://www.baeldung.com/parameterized-tests-junit-5
 * - Ref: https://www.baeldung.com/kotlin/junit-5-kotlin
 */
class DeliveryServiceTest {
    @ParameterizedTest
    @ValueSource(longs = [-1, 0, 1, 2])
    fun can_detect_an_invalid_delivery_date(daysFromDow: Long) {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(daysFromDow)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(isValid).isFalse
    }

    @Test
    fun the_soonest_delivery_date_is_three_days_from_now() {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(3)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(isValid).isTrue
    }
}