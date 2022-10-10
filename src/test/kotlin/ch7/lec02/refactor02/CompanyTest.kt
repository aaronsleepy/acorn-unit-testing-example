package ch7.lec02.refactor02

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * 7.3.1 도메인 계층과 유틸리티 코드 테스트하기
 * Test on sut:
 * @see Company
 */
class CompanyTest {
    @ParameterizedTest
    @CsvSource(
        "mycorp.com,email@mycorp.com,true",
        "mycorp.com,email@gmail.com,false",
    )
    fun differentiates_a_corporate_email_from_non_corporate(
        domain: String, email: String, expectedResult: Boolean) {
        // given-Arrange
        val sut = Company(domain, 0)

        // when-Act
        val isEmailCorporate = sut.isEmailCorporate(email)

        // then-Assert
        assertThat(isEmailCorporate).isEqualTo(expectedResult)

    }
}