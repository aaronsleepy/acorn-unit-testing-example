package ch4.lec02

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class MessageRendererTest {
    @Test
    fun messageRenderer_uses_correct_sub_renderers() {
        // given-Arrange
        val sut = MessageRenderer()

        // when-Act
        val renderers = sut.subRenderers

        // then-Assert
        assertThat(renderers.size).isEqualTo(3)
        assertThat(renderers[0] is HeaderRenderer).isTrue
        assertThat(renderers[1] is BodyRenderer).isTrue
        assertThat(renderers[2] is FooterRenderer).isTrue
    }
}