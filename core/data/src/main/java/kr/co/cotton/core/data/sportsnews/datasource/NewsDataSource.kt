package kr.co.cotton.core.data.sportsnews.datasource

import kr.co.cotton.core.data.sportsnews.model.News

interface NewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getNewsList(page: Int): List<News>

    fun updateNewsList(page: Int, value: List<News>)
}