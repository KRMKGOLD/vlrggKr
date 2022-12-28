package kr.co.cotton.core.data.search.model


sealed class SearchResult(
    val imgSrc: String? = null,
    val href: String? = null,
    val url: String? = null
) {

    data class SearchTeam(
        val name: String? = null,
        val inactiveStr: String? = null,
        val previouslyStr: String? = null,
        val currentlyStr: String? = null
    ) : SearchResult()

    data class SearchPlayer(
        val nickname: String? = null,
        val realName: String? = null,
    ) : SearchResult()

    data class SearchEvent(
        val title: String? = null,
        val eventPeriod: String? = null,
        val prizePool: String? = null
    ) : SearchResult()

    data class SearchSeries(
        val title: String? = null
    ) : SearchResult()
}