package ch1.lec01.ex2

/**
 * 예제 1.2 마지막 결과를 기록하는 isStringLong 버전
 */

var wasLastStringLong: Boolean? = false

fun isStringLong3(input: String): Boolean {
    val result = input.length > 5
    wasLastStringLong = result
    return result
}