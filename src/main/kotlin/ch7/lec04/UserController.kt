package ch7.lec04

/**
 * 예제 7.5 리팩토링 후 컨트롤러
 */
class UserController(
    private val _database: Database = Database(),
    private val _messageBus: MessageBus = MessageBus(),
    ) {
    fun changeEmail(userId: Int, newEmail: String) {
        val data = _database.getUserById(userId)
        val user = data?.let { UserFactory.create(it) }


        val companyData = _database.getCompany()
        val company = companyData?.let { CompanyFactory.create(it) }

        user?.changeEmail(newEmail, company)

        _database.saveCompany(company)
        _database.saveUser(user)
        _messageBus.sendEmailChangedMessage(userId, newEmail)
    }
}