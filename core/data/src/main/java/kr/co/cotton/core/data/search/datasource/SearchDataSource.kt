package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult

interface SearchDataSource {
    fun getAllSearchData(query: String): List<SearchResult>
    fun getSearchDataWithCategory(category: SearchResult, query: String): List<SearchResult>
}