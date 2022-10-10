package ch7.lec02.refactor01

/**
 * 예제 7.2 애플리케이션 서비스, 버전 1의 User
 * - 컴파일 에러 나는 등 문제가 있는 상황
 */
class User(
    var userId: Int = 0,
    var email: String = "",
    var type: UserType = UserType.EMPLOYEE,
) {
    fun changeEmail(newEmail: String,
                    companyDomainName: String, numberOfEmployees: Int): Int {
        if (email == newEmail) {
//            return
            return -1
        }

        val emailDomain = newEmail.split("@")[1]
        val isEmailCorporate = emailDomain == companyDomainName
        val newType = if (isEmailCorporate) UserType.EMPLOYEE else UserType.CUSTOMER

        var newNumberOfEmployees = numberOfEmployees
        if (type != newType) {
            val delta = if (newType == UserType.EMPLOYEE) 1 else -1
            val newNumber = numberOfEmployees + delta
            newNumberOfEmployees = newNumber
        }

        email = newEmail
        type = newType

        return newNumberOfEmployees
    }
}

enum class UserType(
    val code: Int,
) {
    CUSTOMER(1),
    EMPLOYEE(2),
}