package ch6.lec01



class Controller(
    private val _emailGateway: IEmailGateway
) {
    fun greetUser(email: String): Unit {
        _emailGateway.sendGreetingsEmail(email)
    }
}
