package kr.co.cotton.core.data.detailnews.datasource

import org.jsoup.Jsoup
import javax.inject.Inject

class RemoteDetailNewsDataSource @Inject constructor() : DetailNewsDataSource {

    override fun getDetailNews(nId: String, title: String): String {
        val url = "https://www.vlr.gg/$nId/$title"
        val doc = Jsoup.connect(url).get()
        return doc.select("wf-card mod-article").html()
    }
}
