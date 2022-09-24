package ch5.lec02

import ch4.lec02.*

/**
 * 예제 5.7 구현 세부 사항으로서의 상태
 * - 4장의 MessageRenderer와 동일
 */
class MessageRenderer(
    private val _subRenderers: List<IRenderer> = listOf(
        HeaderRenderer(),
        BodyRenderer(),
        FooterRenderer()
    )
): IRenderer {
    val subRenderers: List<IRenderer>       // 공개된 세부 구현 상태
        get() {return this._subRenderers}

    override fun render(message: Message): String {
        return subRenderers.joinToString("") { it.render(message) }
    }
}