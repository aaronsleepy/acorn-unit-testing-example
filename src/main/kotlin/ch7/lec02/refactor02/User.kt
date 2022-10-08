package ch7.lec02.refactor02

/**
 * 예제 7.6 리팩터링 후 User
 */
class User(
    var userId: Int = 0,
    var email: String = "",
    var type: UserType = UserType.EMPLOYEE,
) {
    fun changeEmail(newEmail: String, company: Company?) {
        if (email == newEmail) {
            return
        }

        val newType = if (company?.isEmailCorporate(newEmail) == true)
            UserType.EMPLOYEE else UserType.CUSTOMER

        if (type != newType) {
            val delta = if (newType == UserType.EMPLOYEE) 1 else -1
            company?.changeNumberOfEmployees(delta)
        }

        email = newEmail
        type = newType
    }
}

enum class UserType(
    val code: Int,
) {
    CUSTOMER(1),
    EMPLOYEE(2),
}