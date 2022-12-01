package kr.co.cotton.data.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.co.cotton.data.model.ValEsportsNews
import javax.inject.Inject

class RemoteValEsportsNewsDataSource @Inject constructor() : ValEsportsNewsDataSource {

    override fun getValEsportsNews(): Flow<List<ValEsportsNews>> = flow {

    }
}