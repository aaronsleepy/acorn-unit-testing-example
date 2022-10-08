package ch7.lec02

class MessageBus {
    companion object {
        private lateinit var bus: IBus

        fun sendEmailChangedMessage(userId: Int, newEmail: String) {
            bus.send("Subject: USER; Type: EMAIL CHANGED; id: ${userId}, newEmail: $newEmail")

        }

    }
}

internal interface IBus {
    fun send(message: String)
}