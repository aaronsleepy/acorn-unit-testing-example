package ch1.lec01.ex2

import org.junit.jupiter.api.Test

class Lec01Ex3Test {
    /**
     * 예제 1.3 검증이 없는 테스트는 언제나 통과한다
     */
    @Test
    fun isStringLong3Test() {
        isStringLong3("abc")
        isStringLong3("abcdef")
    }
}