package kr.co.cotton.core.data.search.model

sealed class SearchResult(
    open val imgSrc: String?,
    open val href: String?,
    open val url: String?
) {

    data class SearchTeam(
        override val imgSrc: String? = null,
        override val href: String? = null,
        override val url: String? = null,
        val name: String? = null,
        val inactiveStr: String? = null,
        val previouslyStr: String? = null,
        val currentlyStr: String? = null,
    ) : SearchResult(imgSrc, href, url)

    data class SearchPlayer(
        override val imgSrc: String? = null,
        override val href: String? = null,
        override val url: String? = null,
        val nickname: String? = null,
        val realName: String? = null,
    ) : SearchResult(imgSrc, href, url)

    data class SearchEvent(
        override val imgSrc: String? = null,
        override val href: String? = null,
        override val url: String? = null,
        val title: String? = null,
        val eventPeriod: String? = null,
        val prizePool: String? = null
    ) : SearchResult(imgSrc, href, url)

    data class SearchSeries(
        override val imgSrc: String? = null,
        override val href: String? = null,
        override val url: String? = null,
        val title: String? = null
    ) : SearchResult(imgSrc, href, url)
}