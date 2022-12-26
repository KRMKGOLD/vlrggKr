package kr.co.cotton.core.data.sportsnews.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kr.co.cotton.core.data.sportsnews.model.ValEsportsNews
import kr.co.cotton.core.data.sportsnews.datasource.ValEsportsNewsDataSource
import javax.inject.Inject
import javax.inject.Named

class DefaultValEsportsNewsRepository @Inject constructor(
    @Named("REMOTE") private val remoteValEsportsNewsDataSource: ValEsportsNewsDataSource,
    @Named("LOCAL") private val localValEsportsNewsDataSource: ValEsportsNewsDataSource,
) : ValEsportsNewsRepository {

    override fun getNewsMaxIndex(): Flow<Int> = flow {
        emit(remoteValEsportsNewsDataSource.getNewsMaxIndex())
    }.flowOn(Dispatchers.IO)

    override fun getValEsportsNews(): Flow<PagingData<ValEsportsNews>> {
        return Pager(PagingConfig(10)) {
            VlrEsportsNewsPagingSource(
                remoteValEsportsNewsDataSource,
                localValEsportsNewsDataSource
            )
        }.flow
    }
}