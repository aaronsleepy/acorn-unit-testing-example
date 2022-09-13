package ch4.lec02

interface IRenderer {
    fun render(message: Message): String
}

class HeaderRenderer : IRenderer {
    override fun render(message: Message): String {
        return "<b>${message.header}</b>"
    }
}

class BodyRenderer : IRenderer {
    override fun render(message: Message): String {
        return "<b>${message.body}</b>"
    }
}

class FooterRenderer : IRenderer {
    override fun render(message: Message): String {
        return "<b>${message.footer}</b>"
    }
}