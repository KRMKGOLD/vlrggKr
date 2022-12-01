package kr.co.cotton.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.model.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(page: Int): Flow<List<ValEsportsNews>>
}