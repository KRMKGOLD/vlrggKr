package kr.co.cotton.core.data.sportsnews.datasource

import kr.co.cotton.core.data.sportsnews.model.News

interface NewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getValEsportsNews(page: Int): List<News>

    fun updateValEsportsNews(page: Int, value: List<News>)
}