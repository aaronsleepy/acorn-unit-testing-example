package ch3.lec11

import ch3.lec10.Delivery
import ch3.lec10.DeliveryService
import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime

/**
 * 예제 3.11 몇 가지 사실을 포괄하는 테스트
 */
class DeliveryServiceTest {
    @ParameterizedTest
    @CsvSource(
        "-1,false",
        "0,false",
        "1,false",
        "2,false",
        "3,true",
    )
    fun can_detect_an_invalid_delivery_date(daysFromDow: Long, expected: Boolean) {
        // given-Arrange
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(daysFromDow)
        val delivery = Delivery(pastDate)

        // when-Act
        val isValid = sut.isDeliveryValid(delivery)

        // then-Assert
        AssertionsForInterfaceTypes.assertThat(isValid).isEqualTo(expected)
    }
}