package kr.co.cotton.core.data.detailnews.repository

import kotlinx.coroutines.flow.Flow

interface DetailNewsRepository {

    fun getDetailNews(nId: String, title: String): Flow<String>
}
