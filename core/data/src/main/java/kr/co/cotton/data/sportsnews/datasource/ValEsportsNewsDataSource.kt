package kr.co.cotton.data.sportsnews.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.sportsnews.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getValEsportsNews(page: Int): List<ValEsportsNews>

    fun updateValEsportsNews(page: Int, value: List<ValEsportsNews>)
}