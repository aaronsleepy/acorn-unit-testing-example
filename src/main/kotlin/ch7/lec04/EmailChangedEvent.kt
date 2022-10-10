package ch7.lec04

data class EmailChangedEvent(
    val userId: Int,
    val newEmail: String,
)
