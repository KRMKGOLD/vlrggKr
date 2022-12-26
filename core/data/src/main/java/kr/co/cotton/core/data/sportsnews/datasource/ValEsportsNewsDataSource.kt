package kr.co.cotton.core.data.sportsnews.datasource

import kr.co.cotton.core.data.sportsnews.model.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getValEsportsNews(page: Int): List<ValEsportsNews>

    fun updateValEsportsNews(page: Int, value: List<ValEsportsNews>)
}