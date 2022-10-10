package ch7.lec04

/**
 * 예제 7.4 도메인 계층의 새로운 클래스
 */
class Company(
    var _domainName: String = "",
    var _numberOfEmployees: Int = 0,
) {
    val domainName
        get() = this._domainName

    val numberOfEmployees
        get() = this._numberOfEmployees

    fun changeNumberOfEmployees(delta: Int) {
        assert(numberOfEmployees + delta >= 0)
        _numberOfEmployees += delta
    }

    fun isEmailCorporate(email: String): Boolean {
        val emailDomain = email.split("@")[1]
        return emailDomain == domainName
    }
}