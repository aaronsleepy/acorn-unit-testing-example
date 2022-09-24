package ch3.lec13

import ch3.lec10.Delivery
import ch3.lec10.DeliveryService
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDateTime

/**
 * 예제 3.13 매개변수화된 테스트를 위한 데이터 생성
 */
class DeliveryServiceTest {
    @ParameterizedTest
    @MethodSource("listOfDates")
    fun can_detect_an_invalid_delivery_date(deliveryDate: LocalDateTime, expected: Boolean) {
        // given-Arrange
        val sut = DeliveryService()
        val delivery = Delivery(deliveryDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(isValid).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun listOfDates() = listOf(
            Arguments.of(LocalDateTime.now().plusDays(-1), false),
            Arguments.of(LocalDateTime.now().plusDays(0), false),
            Arguments.of(LocalDateTime.now().plusDays(1), false),
            Arguments.of(LocalDateTime.now().plusDays(2), false),
            Arguments.of(LocalDateTime.now().plusDays(3), true),
        )
    }
}