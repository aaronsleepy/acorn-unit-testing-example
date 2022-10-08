package ch7.lec02.refactor02

class MessageBus {
    private lateinit var bus: IBus

    fun sendEmailChangedMessage(userId: Int, newEmail: String) {
        bus.send("Subject: USER; Type: EMAIL CHANGED; id: ${userId}, newEmail: $newEmail")

    }

}

internal interface IBus {
    fun send(message: String)
}