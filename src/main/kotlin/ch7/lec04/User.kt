package ch7.lec04

/**
 * 예제 7.7 새 속성이 추가된 User
 * 예제 7.12 이메일이 변경될 때 이벤트를 추가하는 User
 */
class User(
    var userId: Int = 0,
    var email: String = "",
    var type: UserType = UserType.EMPLOYEE,
    // 새 속성
    var isEmailConfirmed: Boolean = false,
    val emailChangedEvents: MutableList<EmailChangedEvent> = mutableListOf(),
) {
    fun canChangeEmail(): String? {
        if (isEmailConfirmed)
            return "Can't change email after it's confirmed"

        return null

    }

    fun changeEmail(newEmail: String, company: Company?) {
        assert(canChangeEmail() == null)

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
        // 새 이벤트는 이메일 변경을 나타냄
        emailChangedEvents.add(EmailChangedEvent(userId, newEmail))
    }
}

enum class UserType(
    val code: Int,
) {
    CUSTOMER(1),
    EMPLOYEE(2),
}