package kr.co.cotton.core.data.search.repository

import kotlinx.coroutines.flow.Flow
import kr.co.cotton.core.data.search.model.SearchResult

interface SearchRepository {

    fun getAllSearchData(query: String): Flow<List<SearchResult>>

    fun getSearchDataWithCategory(category: SearchResult, query: String): Flow<List<SearchResult>>
}