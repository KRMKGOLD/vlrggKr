package kr.co.cotton.data.sportsnews.datasource

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.co.cotton.data.sportsnews.ValEsportsNews
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.TextNode
import javax.inject.Inject

class RemoteValEsportsNewsDataSource @Inject constructor() : ValEsportsNewsDataSource {

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

    override fun getValEsportsNews(page: Int): List<ValEsportsNews> {
        try {
            val valEsportsNewsUrl = "https://www.vlr.gg/news/?page=${page}"
            val valEsportsNewsDoc = Jsoup.connect(valEsportsNewsUrl).get()
            val valEsportsNews = getValEsportsNewsWithDoc(valEsportsNewsDoc)

            return valEsportsNews
        } catch (e: Exception) {
            throw e
        }
    }

    override fun updateValEsportsNews(page: Int, value: List<ValEsportsNews>) {
        throw NotImplementedError()
    }

    private fun getNewsMaxIndexWithDoc(document: Document): Int {
        val valEsportsLastIndex =
            document.select("div.action-container-pages a").last()?.text()?.toIntOrNull()

        Log.d("valEsportsLastIndex", "${valEsportsLastIndex ?: "error"}")
        return valEsportsLastIndex ?: 1
    }

    private fun getValEsportsNewsWithDoc(document: Document): List<ValEsportsNews> {
        val valEsportsNewsElement = document.select("div.wf-card a")
        val valEsportsNewsList = mutableListOf<ValEsportsNews>()

        for (news in valEsportsNewsElement) {
            val href = news.attr("href")
            val newsInfoList = news.select("div div")

            val title = newsInfoList[0].text()
            val description = newsInfoList[1].text()
            val flagISO = newsInfoList[2].select("i").attr("class").takeLast(2)
            val dateAndWriter =
                newsInfoList[2].childNodes().filter {
                    it is TextNode && it.text().isNotBlank()
                }.map {
                    (it as? TextNode)?.text()
                }

            valEsportsNewsList.add(
                ValEsportsNews(
                    href = href,
                    title = title,
                    description = description,
                    flagISO = flagISO,
                    date = dateAndWriter.first(),
                    writer = dateAndWriter.last()
                )
            )

            Log.d("valEsportsNewsList", "${flagISO}")
        }

        return valEsportsNewsList
    }
}
