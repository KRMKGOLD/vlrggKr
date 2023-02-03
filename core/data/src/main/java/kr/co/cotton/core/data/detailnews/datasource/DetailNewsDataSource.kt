package kr.co.cotton.core.data.detailnews.datasource

interface DetailNewsDataSource {

    fun getDetailNews(href: String): String
}