package ch5

interface IEmailGateway {
    fun sendGreetingsEmail(userEmail: String): Unit
}