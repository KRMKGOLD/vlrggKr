package kr.co.cotton.core.data.sportsnews.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kr.co.cotton.core.data.sportsnews.model.ValEsportsNews

interface ValEsportsNewsRepository {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(): Flow<PagingData<ValEsportsNews>>
}