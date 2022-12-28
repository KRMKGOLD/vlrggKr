package kr.co.cotton.core.data.search.datasource

import kr.co.cotton.core.data.search.model.SearchResult

interface SearchDataSource {
    fun getAllSearchData(query: String)
    fun <T : SearchResult> getSearchDataWithCategory(category: T, query: String)
}