package ch7.lec02.refactor02

/**
 * 예제 7.3 User 팩토리 클래스
 */
class UserFactory {
    companion object {
        fun create(arr: Array<Any> ): User {
            assert(arr.size >= 3)

            val id = arr?.get(0) as Int
            val email = arr?.get(1) as String
            val type = arr?.get(2) as UserType

            return User(id, email, type)
        }

    }
}