package kr.co.cotton.data.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.model.ValEsportsNews

interface ValEsportsNewsRepository {

    fun getValEsportsNews() : Flow<List<ValEsportsNews>>
}