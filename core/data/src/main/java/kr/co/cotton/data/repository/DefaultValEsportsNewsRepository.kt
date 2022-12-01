package kr.co.cotton.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.datasource.ValEsportsNewsDataSource
import kr.co.cotton.data.model.ValEsportsNews
import javax.inject.Inject

class DefaultValEsportsNewsRepository @Inject constructor(
    private val remoteValEsportsNewsDataSource: ValEsportsNewsDataSource
) : ValEsportsNewsRepository {

    override fun getValEsportsNews(): Flow<List<ValEsportsNews>> {
        return remoteValEsportsNewsDataSource.getValEsportsNews()
    }
}