package ch7.lec02.refactor02

/**
 * 예제 7.4 도메인 계층의 새로운 클래스
 */
class Company(
) {
    var domainName: String = ""
        private set

    var numberOfEmployees: Int = 0
        private set

    fun changeNumberOfEmployees(delta: Int) {
        assert(numberOfEmployees + delta >= 0)
        numberOfEmployees += delta
    }

    fun isEmailCorporate(email: String): Boolean {
        val emailDomain = email.split("@")[1]
        return emailDomain == domainName
    }
}