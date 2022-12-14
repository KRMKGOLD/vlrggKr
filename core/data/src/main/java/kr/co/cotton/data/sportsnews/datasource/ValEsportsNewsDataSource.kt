package kr.co.cotton.data.sportsnews.datasource

import kr.co.cotton.data.model.ValEsportsNews

interface ValEsportsNewsDataSource {

    fun getNewsMaxIndex(): Int

    fun getValEsportsNews(page: Int): List<ValEsportsNews>

    fun updateValEsportsNews(page: Int, value: List<ValEsportsNews>)
}