package ch7.lec02.refactor02

/**
 * 예제 7.2 애플리케이션 서비스, 버전 1
 */
class UserController(
    private val _database: Database = Database(),
    private val _messageBus: MessageBus = MessageBus(),
    ) {
    fun changeEmail(userId: Int, newEmail: String) {
        val data = _database.getUserById(userId)
        val user = data?.let { UserFactory.create(it) }


        val companyData = _database.getCompany()
        val companyDomainName = companyData?.get(0) as String
        val numberOfEmployees = companyData?.get(1) as Int

        val newNumberOfEmployees = user.changeEmail(
            newEmail, companyDomainName, numberOfEmployees)

        _database.saveCompany(newNumberOfEmployees)
        _database.saveUser(user)
        _messageBus.sendEmailChangedMessage(userId, newEmail)
    }
}