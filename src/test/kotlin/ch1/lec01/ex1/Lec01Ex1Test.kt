package ch1.lec01.ex1

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class Lec01Ex1Test {
    @Test
    fun isStringLongTest() {
        val result = isStringLong("abc")
        assertThat(result).isFalse
    }
}