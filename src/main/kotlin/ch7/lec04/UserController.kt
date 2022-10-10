package ch7.lec04

/**
 * 예제 7.5 리팩토링 후 컨트롤러
 * 예제 7.13 도메인 이벤트를 처리하는 컨트롤러
 */
class UserController(
    private val _database: Database = Database(),
    private val _messageBus: MessageBus = MessageBus(),
    ) {
    fun changeEmail(userId: Int, newEmail: String): String {
        val data = _database.getUserById(userId)
        val user = data?.let { UserFactory.create(it) }

        val error = user?.canChangeEmail()
        if (error != null) {
            return error
        }

        val companyData = _database.getCompany()
        val company = companyData?.let { CompanyFactory.create(it) }

        user?.changeEmail(newEmail, company)

        _database.saveCompany(company)
        _database.saveUser(user)
        // 도메인 이벤트 처리
        user?.emailChangedEvents?.forEach {
            _messageBus.sendEmailChangedMessage(it.userId, it.newEmail)

        }

        return "OK"
    }
}