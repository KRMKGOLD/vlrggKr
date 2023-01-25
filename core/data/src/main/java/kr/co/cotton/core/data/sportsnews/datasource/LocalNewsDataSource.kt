package kr.co.cotton.core.data.sportsnews.datasource

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kr.co.cotton.core.data.sportsnews.model.News
import javax.inject.Inject

class LocalNewsDataSource @Inject constructor() : NewsDataSource {

    private val newsMap =
        MutableStateFlow<MutableMap<Int, List<News>>>(mutableMapOf())

    override fun getNewsMaxIndex(): Int {
        throw NotImplementedError()
    }

    override fun getValEsportsNews(page: Int): List<News> {
        return newsMap.value[page] ?: emptyList()
    }

    override fun updateValEsportsNews(page: Int, value: List<News>) {
        newsMap.update {
            it[page] = value
            it
        }
    }
}