package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import javax.inject.Inject

class RemoteSearchDataSource @Inject constructor() : SearchDataSource {

    private fun getUrl(query: String, category: String): String =
        "https://www.vlr.gg/search/?q=${query}&type=${category}"

    override fun getAllSearchData(query: String): List<SearchResult> {
        return getSearcResultWithCategoryStr(query, "all")
    }

    override fun getSearchDataWithCategory(
        category: SearchResult,
        query: String
    ): List<SearchResult> {
        return when (category) {
            is SearchResult.SearchTeam -> {
                getSearcResultWithCategoryStr(query, "teams")
            }
            is SearchResult.SearchPlayer -> {
                getSearcResultWithCategoryStr(query, "players")
            }
            is SearchResult.SearchEvent -> {
                getSearcResultWithCategoryStr(query, "events")
            }
            is SearchResult.SearchSeries -> {
                getSearcResultWithCategoryStr(query, "series")
            }
        }
    }

    private fun getSearcResultWithCategoryStr(query: String, category: String): List<SearchResult> {
        try {
            val url = getUrl(query, category)
            val doc = Jsoup.connect(url).get()
            val list = doc.select("div.wf-card a")
            val searchResultList = mutableListOf<SearchResult>()

            for (searchData in list) {
                searchResultList.add(getSearchResultWithElements(searchData))
            }

            return searchResultList
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getSearchResultWithElements(element: Element): SearchResult {
        val href = element.attr("href")
        val urlWithHref = "https://www.vlr.gg${href}"

        val imgSrc = element.select("img").attr("src")
        val imgSrcWithUrl = if (imgSrc.startsWith("//")) {
            "https:$imgSrc"
        } else if (imgSrc.startsWith("/")) {
            "https://www.vlr.gg$imgSrc"
        } else {
            imgSrc
        }

        return when {
            href.startsWith("/team") -> {
                val name = element.select("div.search-item-title")
                val desc = element.select("div.search-item-desc")

                val splitName = name.text().split("(")
                val teamName = splitName.getOrNull(0)?.trim()
                val inactiveStr = splitName.getOrNull(1)?.dropLast(1)?.trim()

                SearchResult.SearchTeam(
                    imgSrc = imgSrcWithUrl,
                    href = href,
                    url = urlWithHref,
                    name = teamName,
                    inactiveStr = inactiveStr,
                    prevOrCurrentStr = desc.text().trim()
                )
            }
            href.startsWith("/player") -> {
                val nickname = element.select("div.search-item-title").text()
                val realName = element.select("div.search-item-desc").text()

                SearchResult.SearchPlayer(
                    imgSrc = imgSrcWithUrl,
                    href = href,
                    url = urlWithHref,
                    nickname = nickname,
                    realName = realName
                )
            }
            href.startsWith("/event") -> {
                val title = element.select("div.search-item-title").text()
                val desc = element.select("div.search-item-desc").text()
                val descList = desc.split("–").map { it.trim() }
                val eventPeriodList = descList.getOrNull(1)
                val eventPeriod = eventPeriodList
                    ?.split("to")
                    ?.joinToString(" ~ ") { it.trim() }

                SearchResult.SearchEvent(
                    imgSrc = imgSrcWithUrl,
                    href = href,
                    url = urlWithHref,
                    title = title,
                    eventPeriod = eventPeriod,
                    prizePool = descList.getOrNull(2)
                )
            }
            else -> {
                val title = element.select("div.search-item-title").text()

                SearchResult.SearchSeries(
                    imgSrc = imgSrcWithUrl,
                    href = href,
                    url = urlWithHref,
                    title = title
                )
            }
        }
    }
}
