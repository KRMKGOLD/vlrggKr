package kr.co.cotton.data.sportsnews.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.sportsnews.datasource.ValEsportsNewsDataSource
import kr.co.cotton.data.sportsnews.ValEsportsNews
import javax.inject.Inject

class DefaultValEsportsNewsRepository @Inject constructor(
    private val remoteValEsportsNewsDataSource: ValEsportsNewsDataSource
) : ValEsportsNewsRepository {

    override fun getNewsMaxIndex(): Flow<Int> {
        return remoteValEsportsNewsDataSource.getNewsMaxIndex()
    }

    override fun getValEsportsNews(page: Int): Flow<List<ValEsportsNews>> {
        return remoteValEsportsNewsDataSource.getValEsportsNews(page)
    }
}