package kr.co.cotton.data.sportsnews.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.sportsnews.ValEsportsNews

interface ValEsportsNewsRepository {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(page: Int): Flow<List<ValEsportsNews>>
}