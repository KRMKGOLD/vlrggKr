package kr.co.cotton.core.data.sportsnews.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kr.co.cotton.core.data.sportsnews.model.News
import kr.co.cotton.core.data.sportsnews.datasource.NewsDataSource
import javax.inject.Inject
import javax.inject.Named

class DefaultNewsRepository @Inject constructor(
    @Named("REMOTE") private val remoteNewsDataSource: NewsDataSource,
    @Named("LOCAL") private val localNewsDataSource: NewsDataSource,
) : NewsRepository {

    override fun getNewsMaxIndex(): Flow<Int> = flow {
        emit(remoteNewsDataSource.getNewsMaxIndex())
    }.flowOn(Dispatchers.IO)

    override fun getValEsportsNews(): Flow<PagingData<News>> {
        return Pager(PagingConfig(10)) {
            NewsPagingSource(
                remoteNewsDataSource,
                localNewsDataSource
            )
        }.flow
    }
}