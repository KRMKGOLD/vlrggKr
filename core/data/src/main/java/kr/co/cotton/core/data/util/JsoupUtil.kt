package kr.co.cotton.core.data.util

import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode

object JsoupUtil {

    fun Element.filterEmptyNode(): List<Node> {
        return this.childNodes()
            .filterNot {
                it is TextNode && it.text().isBlank()
            }
    }
}
