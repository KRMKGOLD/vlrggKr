package kr.co.cotton.core.data.news.datasource

import android.util.Log
import kr.co.cotton.core.data.news.model.News
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.TextNode
import javax.inject.Inject

class RemoteNewsDataSource @Inject constructor() : NewsDataSource {

    override fun getNewsMaxIndex(): Int {
        try {
            val valEsportsNewsUrl = "https://www.vlr.gg/news"
            val valEsportsNewsDoc = Jsoup.connect(valEsportsNewsUrl).get()
            val maxIndex = getNewsMaxIndexWithDoc(valEsportsNewsDoc)

            return maxIndex
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getNewsList(page: Int): List<News> {
        try {
            val valEsportsNewsUrl = "https://www.vlr.gg/news/?page=${page}"
            val valEsportsNewsDoc = Jsoup.connect(valEsportsNewsUrl).get()
            val valEsportsNews = getValEsportsNewsWithDoc(valEsportsNewsDoc)

            return valEsportsNews
        } catch (e: Exception) {
            throw e
        }
    }

    override fun updateNewsList(page: Int, value: List<News>) {
        throw NotImplementedError()
    }

    private fun getNewsMaxIndexWithDoc(document: Document): Int {
        val valEsportsLastIndex =
            document.select("div.action-container-pages a").last()?.text()?.toIntOrNull()

        Log.d("valEsportsLastIndex", "${valEsportsLastIndex ?: "error"}")
        return valEsportsLastIndex ?: 1
    }

    private fun getValEsportsNewsWithDoc(document: Document): List<News> {
        val valEsportsNewsElement = document.select("div.wf-card a")
        val newsList = mutableListOf<News>()

        for (news in valEsportsNewsElement) {
            val newsInfoList = news.select("div div")

            val href = news.attr("href")
            val url = "https://www.vlr.gg${href}"
            val title = newsInfoList[0].text()
            val description = newsInfoList[1].text()
            val flagISO = newsInfoList[2].select("i").attr("class").takeLast(2)
            val dateAndWriter = newsInfoList[2]
                .childNodes()
                .filter {
                    it is TextNode && it.text().isNotBlank()
                }.map {
                    (it as? TextNode)?.text()
                }

            newsList.add(
                News(
                    href = href,
                    url = url,
                    title = title,
                    description = description,
                    flagISO = flagISO,
                    date = dateAndWriter.first(),
                    writer = dateAndWriter.last()
                )
            )

            Log.d("valEsportsNewsList", "${title}")
        }

        return newsList
    }
}
