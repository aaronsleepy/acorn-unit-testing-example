package ch5.lec03

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 예제 5.10 취약한 테스트로 이어지지 않는 목 사용
 * - 미완성: sut.purchase()시 false 리턴
 * - 고전파는 데이터베이스로부터 조회(Query) 의존성에 대해서는 Mock을 사용하지 않고, 직접 연동하는 방식을 선호하나??
 * - 6장/7장에 내용 나온다고 함
 */
class Lec03Ex10 {
    @Test
    fun successful_purchase() {
        // given-Arrange
        val mock = mockk<IEmailGateway>()
        every { mock.sendReceipt("aaron@kmong.com", "Shampoo", 5) } returns Unit
        val sut = CustomerController(mock)

        // when-Act
        val isSuccess = sut.purchase(customerId = 1, productId = 2, quantity = 5)

        // then-Assert
        assertThat(isSuccess).isTrue
        verify(exactly = 1) { mock.sendReceipt(
            "aaron@kmong.com", "Shampoo", 5) }  // 시스템이 구매에 대한 영수증을 보내는지 검증
    }
}
