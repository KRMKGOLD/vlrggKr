package kr.co.cotton.data.sportsnews.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kr.co.cotton.data.sportsnews.ValEsportsNews
import javax.inject.Inject

class LocalValEsportsNewsDataSource @Inject constructor() : ValEsportsNewsDataSource {

    private val valEsportsNewsMap =
        MutableStateFlow<MutableMap<Int, List<ValEsportsNews>>>(mutableMapOf())

    override fun getNewsMaxIndex(): Int {
        throw NotImplementedError()
    }

    override fun getValEsportsNews(page: Int): List<ValEsportsNews> {
        return valEsportsNewsMap.value[page] ?: emptyList()
    }

    override fun updateValEsportsNews(page: Int, value: List<ValEsportsNews>) {
        valEsportsNewsMap.value[page] = value
    }
}