package ch5

class Report(
    private val _numberOfUsers: Int,
) {
    val numberOfUsers
        get() = this._numberOfUsers
}