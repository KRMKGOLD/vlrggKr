package kr.co.cotton.core.data.sportsnews.model

data class ValEsportsNews(
    val href: String? = null,
    val url: String? = null,
    val title: String? = null,
    val description: String? = null,
    val flagISO: String? = null,
    val date: String? = null,
    val writer: String? = null
) {

    val isDataEmpty = listOfNotNull(href, url, title, description, flagISO, date, writer).isEmpty()
}