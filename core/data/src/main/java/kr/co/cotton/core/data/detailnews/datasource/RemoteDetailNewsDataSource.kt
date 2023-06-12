package kr.co.cotton.core.data.detailnews.datasource

import android.util.Log
import org.jsoup.Jsoup
import javax.inject.Inject
import kr.co.cotton.core.data.util.JsoupUtil.filterEmptyNode
import org.jsoup.nodes.Element

class RemoteDetailNewsDataSource @Inject constructor() : DetailNewsDataSource {

    override fun getDetailNews(nId: String, title: String): String {
        val url = "https://www.vlr.gg/$nId/$title"
        val doc = Jsoup.connect(url).get()
        return doc.select("div.wf-card.mod-article").html()
    }
}

fun main() {
    val url = "https://www.vlr.gg/224490/nrg-take-down-navi-after-three-map-battle"
    val doc = Jsoup.connect(url).get()

    val full = doc.select("div.wf-card.mod-article")
    val header = full.select("div.article-header")
    val body = full.select("div.article-body")

    val title = (header[0].filterEmptyNode()[0] as Element).text()
    val k = body[0].filterEmptyNode()

    println(full.toString())
}
