package ch4.lec02

class MessageRenderer(
    private val _subRenderers: List<IRenderer> = listOf(
        HeaderRenderer(),
        BodyRenderer(),
        FooterRenderer()
    )
): IRenderer {
    val subRenderers: List<IRenderer>
        get() {return this._subRenderers}

    override fun render(message: Message): String {
        return subRenderers.joinToString("") { it.render(message) }
    }
}