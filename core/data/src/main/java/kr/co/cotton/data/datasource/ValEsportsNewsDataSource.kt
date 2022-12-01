package kr.co.cotton.data.datasource

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.model.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getValEsportsNews(): Flow<List<ValEsportsNews>>
}