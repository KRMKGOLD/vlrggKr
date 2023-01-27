package kr.co.cotton.core.data.news.datasource

import kr.co.cotton.core.data.news.model.News

interface NewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getNewsList(page: Int): List<News>

    fun updateNewsList(page: Int, value: List<News>)
}