package ch7.lec02.refactor02

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

/**
 * 7.3.1 도메인 계층과 유틸리티 코드 테스트하기
 * Test on sut:
 * @see  ch7.lec02.refactor02.Company
 */
class UserTest {
    @Test
    fun changing_email_from_non_corporate_to_corporate() {
        // given-Arrange
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@gmail.com", UserType.CUSTOMER)

        // when-Act
        sut.changeEmail("new@mycorp.com", company)

        // then-Assert
        assertThat(company.numberOfEmployees).isEqualTo(2)
        assertThat(sut.email).isEqualTo("new@mycorp.com")
        assertThat(sut.type).isEqualTo(UserType.EMPLOYEE)
    }

    @Test
    fun changing_email_from_corporate_to_non_corporate() {
        // given-Arrange
        val company = Company("mycorp.com", 1)
        val sut = User(1, "user@mycorp.com", UserType.EMPLOYEE)

        // when-Act
        sut.changeEmail("new@gmail.com", company)

        // then-Assert
        assertThat(company.numberOfEmployees).isEqualTo(0)
        assertThat(sut.email).isEqualTo("new@gmail.com")
        assertThat(sut.type).isEqualTo(UserType.CUSTOMER)
    }
}