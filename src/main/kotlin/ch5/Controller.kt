package ch5

class Controller(
) {
    private lateinit var _emailGateWay: IEmailGateway
    private lateinit var _database: IDatabase

    constructor(emailGateWay: IEmailGateway) : this() {
        _emailGateWay = emailGateWay
    }

    constructor(database: IDatabase) : this() {
        _database = database
    }

    fun greetUser(userEmail: String): Unit {
        _emailGateWay.sendGreetingsEmail(userEmail)
    }

    fun createReport(): Report {
        val numberOfUsers = _database.getNumberOfUsers()
        return Report(numberOfUsers)
    }
}