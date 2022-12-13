package kr.co.cotton.data.sportsnews.repository

import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import kr.co.cotton.data.sportsnews.ValEsportsNews

interface ValEsportsNewsRepository {

    fun getNewsMaxIndex(): Flow<Int>

    fun getValEsportsNews(): Flow<PagingData<ValEsportsNews>>
}