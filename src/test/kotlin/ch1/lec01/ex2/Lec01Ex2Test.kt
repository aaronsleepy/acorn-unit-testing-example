package ch1.lec01.ex2

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class Lec01Ex2Test {
    @Test
    fun isStringLong3Test() {
        val result = isStringLong3("abc")
        assertThat(result).isFalse
    }
}