package ch7.lec02

class User(
    var userId: Int = 0,
    var email: String = "",
    var type: UserType = UserType.EMPLOYEE,
) {
    fun changeEmail(targetUserId: Int, newEmail: String) {
        // 데이터베이스에서 사용자의 현재 이메일과 유형 검색
        val data = Database.getUserById(userId)
        userId = targetUserId
        email = data?.get(1) as String
        type = data?.get(2) as UserType

        if (email == newEmail) {
            return
        }

        // 데이터베이스에서 조직의 도메인 이름과 직원 수 검색
        val companyData = Database.getCompany()
        val companyDomainName = companyData?.get(0) as String
        val numberOfEmployees = companyData?.get(1) as Int

        val emailDomain = newEmail.split("@")[1]
        val isEmailCorporate = emailDomain == companyDomainName

        // 새 이메일의 도메인 이름에 따라 사용자 유형 설정
        val newType = if (isEmailCorporate) UserType.EMPLOYEE else UserType.CUSTOMER

        // 필요한 경우 죅의 직원 수 업데이트
        if (type != newType) {
            val delta = if (newType == UserType.EMPLOYEE) 1 else -1
            val newNumber = numberOfEmployees + 1
            Database.saveCompany(newNumber)
        }

        email = newEmail
        type = newType

        // 데이터베이스에 사용자 저장
        Database.saveUser(this)
        // 메시지 버스에 알림 전송
        MessageBus.sendEmailChangedMessage(userId, newEmail)

    }
}

enum class UserType(
    val code: Int,
) {
    CUSTOMER(1),
    EMPLOYEE(2),
}