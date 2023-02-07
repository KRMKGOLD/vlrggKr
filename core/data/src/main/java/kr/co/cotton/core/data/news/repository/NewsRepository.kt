package kr.co.cotton.core.data.news.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.cotton.core.data.news.model.News

interface NewsRepository {

    fun getNewsMaxIndex(): Flow<Int>

    fun getNewsList(): Flow<PagingData<News>>
}