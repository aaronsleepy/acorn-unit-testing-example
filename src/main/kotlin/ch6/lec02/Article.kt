package ch6.lec02

import java.time.LocalDateTime

class Article(
    private val _comments: MutableList<Comment> = mutableListOf<Comment>(),
) {
    val comments: List<Comment>
        get() = this._comments

    fun addComment(text: String, author: String, now: LocalDateTime) {
        _comments.add(Comment(text, author, now))
    }
}