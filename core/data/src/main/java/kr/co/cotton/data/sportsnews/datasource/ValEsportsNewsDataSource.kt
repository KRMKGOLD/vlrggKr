package kr.co.cotton.data.sportsnews.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.sportsnews.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(page: Int): Flow<List<ValEsportsNews>>
}