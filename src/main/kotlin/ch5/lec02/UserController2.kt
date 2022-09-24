package ch5.lec02

/**
 * 예제 5.6 API가 잘 설계된 User 클래스
 */
class GoodUser (
) {
    private lateinit var _name: String

    var name: String
        set(value) {
            normalizeName(value).also { _name = it }
        }
        get() = _name

    private fun normalizeName(name: String?): String {
        val result = name?.trim() ?: ""

        if (result.length > 50) {
            return result.substring(0, 50)
        }

        return result
    }
}


class UserController2 {
    fun renameUser(userId: Int, newName: String) {
        val user = getUserFromDatabase(userId)

        user.name = newName

        saveToDatabase(user)

    }

    private fun saveToDatabase(user: GoodUser) {
        // TODO: 구현 필요
    }

    private fun getUserFromDatabase(userId: Int): GoodUser {
        // TODO: 구현 필요
        return GoodUser()

    }
}
