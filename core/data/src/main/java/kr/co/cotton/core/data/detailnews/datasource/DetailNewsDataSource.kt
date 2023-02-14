package kr.co.cotton.core.data.detailnews.datasource

interface DetailNewsDataSource {

    fun getDetailNews(nId: String, title: String): String
}
