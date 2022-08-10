package ch1.lec01.ex1

/**
 * 예제 1.1 에제 메서드를 부분적으로 다루는 테스트
 */
fun isStringLong(input: String): Boolean {
    if (input.length > 5) {
        return true
    }
    return false

    // 라인수가 줄어드면 code coverage는 증가하지만
    // 하지만 테스트 suite의 가치가 높아지는 것은 아니다.
    // return input.length > 5
}