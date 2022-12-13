package kr.co.cotton.data.sportsnews

data class ValEsportsNews(
    val href: String? = null,
    val title: String? = null,
    val description: String? = null,
    val flagISO: String? = null,
    val date: String? = null,
    val writer: String? = null
) {

    val url: String? = "https://www.vlr.gg${href}"
}