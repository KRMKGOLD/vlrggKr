package kr.co.cotton.core.data.detailnews.datasource

import org.jsoup.Jsoup
import javax.inject.Inject

class RemoteDetailNewsDataSource @Inject constructor() : DetailNewsDataSource {

    override fun getDetailNews(href: String): String {
        val url = "https://www.vlr.gg${href}"
        val doc = Jsoup.connect(url).get()
        return doc.select("wf-card mod-article").html()
    }
}
