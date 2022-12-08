package kr.co.cotton.data.sportsnews.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kr.co.cotton.data.sportsnews.ValEsportsNews
import kr.co.cotton.data.sportsnews.datasource.ValEsportsNewsDataSource
import javax.inject.Inject
import javax.inject.Named

class DefaultValEsportsNewsRepository @Inject constructor(
    @Named("REMOTE") private val remoteValEsportsNewsDataSource: ValEsportsNewsDataSource,
    @Named("LOCAL") private val localValEsportsNewsDataSource: ValEsportsNewsDataSource,
) : ValEsportsNewsRepository {

    override fun getNewsMaxIndex(): Flow<Int> = flow {
        emit(remoteValEsportsNewsDataSource.getNewsMaxIndex())
    }.flowOn(Dispatchers.IO)

    override fun getValEsportsNews(page: Int): Flow<List<ValEsportsNews>> = flow {
        val cached = localValEsportsNewsDataSource.getValEsportsNews(page)
        val data = cached.ifEmpty {
            val remote = remoteValEsportsNewsDataSource.getValEsportsNews(page)
            localValEsportsNewsDataSource.updateValEsportsNews(page, remote)
            remote
        }

        emit(data)
    }.flowOn(Dispatchers.IO)
}