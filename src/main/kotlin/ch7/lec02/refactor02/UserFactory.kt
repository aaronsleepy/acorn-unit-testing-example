package ch7.lec02.refactor02

/**
 * 예제 7.3 User 팩토리 클래스
 */
class UserFactory {
    companion object {
        fun create(arr: Array<Any> ): User {
            assert(arr.size >= 3)

            val id = arr[0] as Int
            val email = arr[1] as String
            val type = arr[2] as UserType

            return User(id, email, type)
        }

    }
}