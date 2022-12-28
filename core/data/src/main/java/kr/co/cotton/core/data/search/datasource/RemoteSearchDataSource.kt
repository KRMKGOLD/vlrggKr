package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult
import org.jsoup.Jsoup
import javax.inject.Inject

class RemoteSearchDataSource @Inject constructor() : SearchDataSource {

    private fun getUrl(query: String, category: String): String =
        "https://www.vlr.gg/search/?q=${query}&type=${category}"

    override fun getAllSearchData(query: String) {
        getSearchDataWithCategoryStr(query, "all")
    }

    override fun <T : SearchResult> getSearchDataWithCategory(category: T, query: String) {
        when (category) {
            is SearchResult.SearchTeam -> {
                getSearchDataWithCategoryStr(query, "teams")
            }
            is SearchResult.SearchPlayer -> {
                getSearchDataWithCategoryStr(query, "players")
            }
            is SearchResult.SearchEvent -> {
                getSearchDataWithCategoryStr(query, "events")
            }
            is SearchResult.SearchSeries -> {
                getSearchDataWithCategoryStr(query, "series")
            }
        }
    }

    private fun getSearchDataWithCategoryStr(query: String, category: String) {
        try {
            val url = getUrl(query, category)
            val doc = Jsoup.connect(url).get()

        } catch (e: Exception) {
            throw e
        }
    }
}

fun main() {
    val url = "https://www.vlr.gg/search/?q=a&type=all"
    val doc = Jsoup.connect(url).get()

    val list = doc.select("div.wf-card a")
    for (searchData in list) {
        val href = searchData.attr("href")

        when {
            href.startsWith("/team") -> {
//                val imgSrc = searchData.select("img").attr("src")
//                val name = searchData.select("div.search-item-title")
//                println(name.getOrNull(0)?.text())
//                val desc = searchData.select("div.search-item-desc")
//                println(desc.getOrNull(0)?.text() + desc.getOrNull(1)?.text())
            }
            href.startsWith("/player") -> {
//                val imgSrc = searchData.select("img").attr("src")
//                val nickname = searchData.select("div.search-item-title")
//                val realName = searchData.select("div.search-item-desc")
//                println(nickname.text() + realName.text())
            }
            href.startsWith("/event") -> {
                val imgSrc = searchData.select("img").attr("src")
                val title = searchData.select("div.search-item-title")
                val desc = searchData.select("div.search-item-desc")
//                println(desc.text()) // TODO : cliped
            }
            else -> {
                val imgSrc = searchData.select("img").attr("src")
                val title = searchData.select("div.search-item-title")
            }
        }
    }
}