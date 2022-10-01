package ch6.lec02

import java.time.LocalDateTime

data class Comment(
    val text: String,
    val author: String,
    val dateCreated: LocalDateTime,
) {
}