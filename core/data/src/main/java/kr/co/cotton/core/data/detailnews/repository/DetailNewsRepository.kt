package kr.co.cotton.core.data.detailnews.repository

import kotlinx.coroutines.flow.Flow

interface DetailNewsRepository {

    fun getDetailNews(href: String): Flow<String>
}