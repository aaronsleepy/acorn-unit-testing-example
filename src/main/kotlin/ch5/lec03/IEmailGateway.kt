package ch5.lec03

interface IEmailGateway {
    fun sendReceipt(email: String, productName: String, quantity: Int): Unit
}