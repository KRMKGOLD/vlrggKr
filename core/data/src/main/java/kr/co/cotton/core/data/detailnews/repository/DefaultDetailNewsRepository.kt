package kr.co.cotton.core.data.detailnews.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kr.co.cotton.core.data.detailnews.datasource.DetailNewsDataSource
import javax.inject.Inject
import javax.inject.Named

class DefaultDetailNewsRepository @Inject constructor(
    @Named("REMOTE") private val remoteDetailNewsDataSource: DetailNewsDataSource,
) : DetailNewsRepository {

    override fun getDetailNews(nId: String, title: String): Flow<String> = flow {
        emit(remoteDetailNewsDataSource.getDetailNews(nId, title))
    }.flowOn(Dispatchers.IO)
}
