package ch5.lec02

/**
 * 예제 5.5 구현 세부 사항을 유출하는 User 클래스
 */
class User(
) {
    lateinit var name: String

    fun normalizeName(name: String?): String {
        val result = name?.trim() ?: ""

        if (result.length > 50) {
            return result.substring(0, 50)
        }

        return result
    }
}

class UserController {
    fun renameUser(userId: Int, newName: String) {
        val user = getUserFromDatabase(userId)

        val normalizedName = user.normalizeName(newName)
        user.name = normalizedName

        saveToDatabase(user)

    }

    private fun saveToDatabase(user: User) {
        // TODO: 구현 필요
    }

    private fun getUserFromDatabase(userId: Int): User {
        // TODO: 구현 필요
        return User()

    }
}
