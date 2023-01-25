package kr.co.cotton.core.data.sportsnews.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.cotton.core.data.sportsnews.model.News

interface NewsRepository {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(): Flow<PagingData<News>>
}