package kr.co.cotton.core.data.detailnews.datasource

import org.jsoup.Jsoup
import javax.inject.Inject
import org.jsoup.select.Elements

class RemoteDetailNewsDataSource @Inject constructor() : DetailNewsDataSource {

    override fun getDetailNews(nId: String, title: String): String {
        val url = "https://www.vlr.gg/$nId/$title"
        val doc = Jsoup.connect(url).get()
        val article = doc.select("div.wf-card.mod-article")
        val header = article.select("div.article-header")
        val body = article.select("div.article-body")

        val (title, writer) = getHeaderList(header)
        getBodyList(body)

        return ""
    }

    private fun getHeaderList(header: Elements): Pair<String, String> {
        val title = header.select("h1.wf-title").text()
        val writer = header.select("a.article-meta-author").text()

        return title to writer
    }

    private fun getBodyList(body: Elements) {

    }
}
