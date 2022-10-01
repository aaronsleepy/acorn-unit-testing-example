package ch6.lec01

interface IEmailGateway {
    fun sendGreetingsEmail(email: String): Unit
}