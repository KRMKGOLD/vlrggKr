package kr.co.cotton.core.data.news.datasource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kr.co.cotton.core.data.news.model.News
import javax.inject.Inject

class LocalNewsDataSource @Inject constructor() : NewsDataSource {

    private val newsMap =
        MutableStateFlow<MutableMap<Int, List<News>>>(mutableMapOf())

    override fun getNewsMaxIndex(): Int {
        throw NotImplementedError()
    }

    override fun getNewsList(page: Int): List<News> {
        return newsMap.value[page] ?: emptyList()
    }

    override fun updateNewsList(page: Int, value: List<News>) {
        newsMap.update {
            it[page] = value
            it
        }
    }
}